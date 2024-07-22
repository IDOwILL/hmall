package com.hmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hmall.order.dto.OrderDTO;
import com.hmall.order.pojo.Order;

public interface IOrderService extends IService<Order> {

    /**
     * 提交订单
     * @param dto
     * @return
     */
    Long placeOrder(OrderDTO dto);
}
