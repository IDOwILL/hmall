package com.hmall.order.controller;

import com.hmall.order.dto.OrderDTO;
import com.hmall.order.pojo.Order;
import com.hmall.order.result.Result;
import com.hmall.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

   @Autowired
   private IOrderService orderService;

   @GetMapping("{id}")
   public Order queryOrderById(@PathVariable("id") Long orderId) {
      return orderService.getById(orderId);
   }

   /**
    * 提交订单
    * @param dto
    * @return
    */
   @PostMapping
   public Result placeOrder(@RequestBody OrderDTO dto) {
      Long orderId=orderService.placeOrder(dto);
      return Result.success(orderId);
   }

}
