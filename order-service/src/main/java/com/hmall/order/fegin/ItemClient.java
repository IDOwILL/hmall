package com.hmall.order.fegin;

import com.hmall.order.dto.OrderDTO;
import com.hmall.order.pojo.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "itemservice")
public interface ItemClient {
    /**\
     * 根据id查询商品
     * @param itemId
     * @return
     */
    @GetMapping("item/{id}")
    Item queryById(@PathVariable("id") Long itemId);
}
