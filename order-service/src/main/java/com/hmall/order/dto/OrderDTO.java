package com.hmall.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    //商品id
    private Long itemId;
    //购买数量
    private Integer num;
    private Long addressId;//收货人地址id
    private Integer paymentType;//付款方式，3表示余额支付
}
