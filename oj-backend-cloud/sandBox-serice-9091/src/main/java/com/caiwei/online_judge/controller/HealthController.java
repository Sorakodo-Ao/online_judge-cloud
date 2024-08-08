package com.caiwei.online_judge.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/health")
    public String healthCheck() {
        return "ok , service port = " + port;
    }
}
