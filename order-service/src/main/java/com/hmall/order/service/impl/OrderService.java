package com.hmall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmall.order.dto.OrderDTO;
import com.hmall.order.fegin.AddressClient;
import com.hmall.order.fegin.ItemClient;
import com.hmall.order.mapper.OrderDetailMapper;
import com.hmall.order.mapper.OrderMapper;
import com.hmall.order.pojo.Address;
import com.hmall.order.pojo.Item;
import com.hmall.order.pojo.Order;
import com.hmall.order.pojo.OrderDetail;
import com.hmall.order.result.Result;
import com.hmall.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class OrderService extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ItemClient itemClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AddressClient addressClient;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    /**
     * 提交订单
     * @param dto
     * @return
     */
    @Override
    @Transactional
    public Long placeOrder(OrderDTO dto) {
        // 使用Feign Client调用Item Service,注意返回值
        Result<Item> Ritem = itemClient.queryById(dto.getItemId());
        Item item = Ritem.getData();
        if (item == null || item.getId() == null) {
            throw new RuntimeException("未找到该商品");
        }
        log.info("商品item:{}",item);
        Address address = addressClient.queryByAddressId(dto.getAddressId());
        if (address == null || address.getId() == null) {
            throw new RuntimeException("未找到此地址");
        }
        log.info("地址address:{}",address);
        //以上完成后进行订单保存
        Long totalFee = item.getPrice() * dto.getNum();
        Order order = Order.builder().totalFee(totalFee).paymentType(dto.getPaymentType()).userId(2L).status(3).build();
        orderMapper.insert(order);
        OrderDetail orderDetail = OrderDetail.builder().orderId(order.getId()).itemId(dto.getItemId()).num(dto.getNum()).price(item.getPrice()).spec(item.getSpec()).image(item.getImage()).build();
        orderDetailMapper.insert(orderDetail);

        return order.getId();
    }
}
