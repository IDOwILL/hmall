package com.hmall.order.fegin;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("userservice")
public interface AddressClient {

}
