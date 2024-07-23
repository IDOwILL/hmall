package com.hmall.order.fegin;

import com.hmall.order.dto.OrderDTO;
import com.hmall.order.pojo.Item;
import com.hmall.order.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "itemservice")
public interface ItemClient {
    /**\
     * 根据id查询商品f
     * @param id
     * @return
     */
    @GetMapping("item/{id}")
    Result<Item> queryById(@PathVariable("id") Long id);

    /**
     * 减少订单
     * @param itemId
     * @param num
     */
    @PutMapping("/item/stock/{itemId}/{num}")
    void reduceItem(@PathVariable("itemId") Long itemId,
                    @PathVariable("num") Integer num);
}
