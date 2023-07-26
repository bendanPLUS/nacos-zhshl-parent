package com.demo.order.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class initCategory {
    @Bean(name = "initAdminCategoryCache")
    public void initCategory(){
        log.info("项目启动初始化一些数据放入缓存");
    }
}
