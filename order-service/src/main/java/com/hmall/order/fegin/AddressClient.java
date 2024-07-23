package com.hmall.order.fegin;

import com.hmall.order.pojo.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userservice")
public interface AddressClient {

    @GetMapping("/address/{id}")
    Address queryByAddressId(@PathVariable("id") Long addressId);
}
