package com.demo.order.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.demo.order.DTO.User;
import com.demo.order.client.StockClient;
import com.demo.order.config.PatterProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
//@RefreshScope //实现配置的热加载
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PatterProperties patterProperties;

    //@Value("${a.b}")
    private String dateformate;

    @Autowired
    private StockClient stockClient;

    @GetMapping("/now")
    public String now() {
        log.info("createOrder请求入参:{}");
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(patterProperties.getDateformat()));
        log.info("dateTime:{}", dateTime);
        return "验证配置的日期: " + dateTime;
    }

    @GetMapping("/order/create")
    public String createOrder(Integer productId, Integer userId) {
        log.info("createOrder请求入参:{}", productId);
        String result = restTemplate.getForObject("http://zhshl-stock/stock/reduce/" + productId, String.class);
        log.info("调用consumer成功:{}", result);
        return "createOrder下单成功,库存响应: " + result;
    }

    //用feign调用
    @GetMapping("/order/create1")
    public String createOrder1(Integer productId, Integer userId) {
        log.info("createOrder-1请求入参:{}", productId);
        //String result = stockClient.reduce(productId);
        String result = "";
        User user = new User();
        user.setName("123");
        stockClient.listUser(user);
        log.info("调用consumer成功:{}", result);
        return "createOrder-1 下单成功,库存响应: " + result;
    }
}