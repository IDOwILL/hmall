package com.hmall.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmall.order.dto.OrderDTO;
import com.hmall.order.fegin.ItemClient;
import com.hmall.order.mapper.OrderMapper;
import com.hmall.order.pojo.Item;
import com.hmall.order.pojo.Order;
import com.hmall.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ItemClient itemClient;

    /**
     * 提交订单
     * @param dto
     * @return
     */
    @Override
    public Long placeOrder(OrderDTO dto) {
        Item item = itemClient.queryById(dto.getItemId());
        if (item.getId() == null) {
            throw new RuntimeException("未找到该商品");
        }
        log.info("商品：{}",item);
        return null;
    }
}
