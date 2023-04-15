package com.freetech.items.itemservice.application.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", path="/v1/products")
public interface ProductFeignClient {
    @GetMapping("/{productId}")
    QueryProductDto getProduct(@PathVariable("productId") Long id);
}
