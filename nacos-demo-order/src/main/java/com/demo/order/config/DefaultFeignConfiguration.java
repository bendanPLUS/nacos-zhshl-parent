package com.demo.order.config;

import com.demo.order.log.MyFeignLogger;
import feign.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultFeignConfiguration {

    @Bean
    public Logger.Level feignLogLevel() {
        return Logger.Level.FULL; // 日志级别为BASIC
    }

    @Bean
    public Logger feignLogger() {
        return new MyFeignLogger();
    }
}
