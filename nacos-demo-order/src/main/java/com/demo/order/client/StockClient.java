package com.demo.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("zhshl-stock")// 必须和cloud.nacos.discovery.service:zhshl-stock-1配置的名称一致
public interface StockClient {
    @GetMapping("/stock/reduce/{productId}")
    String reduce(@PathVariable("productId")Integer productId);
}
