package com.example.zhslstock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class ZhslStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhslStockApplication.class, args);
    }
    @RestController
    public class StockController {
        @Value("${server.port}")
        private String port;

        @GetMapping("/stock/reduce/{productId}")
        public String reduce(@PathVariable Integer productId) {
            System.out.println("减库存成功");
            return "减库存成功,响应的是: " + port;
        }
    }
}
