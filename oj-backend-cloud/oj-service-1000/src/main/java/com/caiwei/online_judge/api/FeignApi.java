package com.caiwei.online_judge.api;

import com.caiwei.online_judge.judge.codeSandBox.model.ExecuteCodeRequest;
import com.caiwei.online_judge.judge.codeSandBox.model.ExecuteCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @auther caiwei
 * @create 2024-7-6
 */
@FeignClient(value = "service-oj-code-sandbox", fallback = FeignApiFallBack.class)
public interface FeignApi {
    @GetMapping("/health")
    String healthCheck();

    @PostMapping("/judge")
    ExecuteCodeResponse judge(@RequestBody ExecuteCodeRequest executeCodeRequest);
}
 