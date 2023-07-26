package com.example.zhslstock;

import com.example.zhslstock.DTO.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

        @PostMapping("user/list")
        List<User> listUser(@RequestBody User req) {
            List<User> list = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                User user = new User();
                user.setName("name" + i);
                user.setAge(i);
                list.add(user);
            }
            return list;
        }
    }
}
