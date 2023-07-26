package com.demo.order.client;

import com.demo.order.DTO.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("zhshl-stock")// 必须和cloud.nacos.discovery.service:zhshl-stock-1配置的名称一致
public interface StockClient {
    @GetMapping("/stock/reduce/{productId}")
    String reduce(@PathVariable("productId")Integer productId);

    /**
     * 用户列表
     */
    @PostMapping("user/list")
    List<User> listUser(@RequestBody User req);
}
