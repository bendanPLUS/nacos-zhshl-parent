package com.demo.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {

    //配置了Swagger的bean实例-->Docket
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    //配置Swagger信息-->apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("TiTi","https://www.csdn.net/","12345@123.com");

        return new ApiInfo(
                "yu.du.demoe.Swagger的Api文档",
                "承诺是一辈子的事,许下的诺言就要努力实现",
                "1.0",
                "https://www.bilibili.com/video/BV1Y441197Lw/?vd_source=a47bf4940c4525104c29456d1bfbdfcf",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }
}
