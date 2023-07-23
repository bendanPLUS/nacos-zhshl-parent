package com.demo.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${a.b}")
    private String dateformate;

    @GetMapping("now")
    public String now() {
        log.info("createOrder请求入参:{}");
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformate));
        log.info("dateTime:{}",dateTime);
        return "验证配置的日期: " + dateTime;
    }

    @GetMapping("/order/create")
    public String createOrder(Integer productId, Integer userId) {
        log.info("createOrder请求入参:{}", productId);
        String result = restTemplate.getForObject("http://zhshl-stock/stock/reduce/" + productId, String.class);
        log.info("调用consumer成功:{}", result);
        return "下单成功,库存响应: " + result;
    }
}