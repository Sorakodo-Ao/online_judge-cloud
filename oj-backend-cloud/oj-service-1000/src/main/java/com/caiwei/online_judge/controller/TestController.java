package com.caiwei.online_judge.controller;

import com.caiwei.online_judge.api.FeignApi;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * feignApi调用测试
 */
@RestController
public class TestController {
    @Resource
    private FeignApi feignApi;

    @GetMapping("/test")
    public String testHealth(){
        return feignApi.healthCheck();
    }
}
