package com.caiwei.online_judge.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        // 标题
                        .title("knife4j")
                        // 描述
                        .description("knife4j接口文档")
                        // 版本
                        .version("v1") 
                        //可以自己设定自己的名字和邮箱还有URL地址
                        .contact(new Contact().name("name").email("email"))
                        .license(new License().name("Apache 2.0")));
    }
}