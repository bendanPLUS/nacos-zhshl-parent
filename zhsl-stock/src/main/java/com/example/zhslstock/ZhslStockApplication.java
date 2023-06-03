package com.example.zhslstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZhslStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhslStockApplication.class, args);
    }

}
