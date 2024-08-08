package com.caiwei.online_judge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@LoadBalancerClients
@EnableFeignClients//开启OpenFeign的功能
public class Main1000 {
    public static void main(String[] args) {
        SpringApplication.run(Main1000.class, args);
    }
}
