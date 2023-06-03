package top.hdsw.zhshlorder.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/create")
    public String createOrder(Integer productId, Integer userId) {

        String result = restTemplate.getForObject("http://zhshl-stock/stock/reduce/" + productId, String.class);
        return "下单成功,库存响应: " + result;
    }
}
