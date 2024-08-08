package com.caiwei.online_judge.judge.codeSandBox.impl;

import com.caiwei.online_judge.api.FeignApi;
import com.caiwei.online_judge.checkComponent.SpringContextHolder;
import com.caiwei.online_judge.judge.codeSandBox.CodeSandBox;
import com.caiwei.online_judge.judge.codeSandBox.model.ExecuteCodeRequest;
import com.caiwei.online_judge.judge.codeSandBox.model.ExecuteCodeResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 * 远程调用沙箱
 */
@Component
public class RemoteCodeSandBox implements CodeSandBox {
    /*    @Resource
        private RestTemplate restTemplate;

        public void setRestTemplate() {
            RestTemplateConfig restTemplateConfig = new RestTemplateConfig();
            this.restTemplate = restTemplateConfig.restTemplate();
       }

        private static final String SERVICE_PROVIDER = "http://localhost:9091";
    */
    /*@Resource
    private FeignApi feignApi;*/
    private static final FeignApi feignApi = SpringContextHolder.getBean(FeignApi.class);
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
       /* System.out.println("remoteSandbox");
        setRestTemplate();
        String url = SERVICE_PROVIDER + "/judge";
        ExecuteCodeResponse executeCodeResponse =
                restTemplate.postForObject(url, executeCodeRequest, ExecuteCodeResponse.class);
        */
        /*String url = SERVICE_PROVIDER + "/health";
        String str = restTemplate.getForObject(url, String.class);
        System.out.println("return string = " + str);
        return null;*/
        ExecuteCodeResponse executeCodeResponse = feignApi.judge(executeCodeRequest);
        System.out.println("remoteSandbox return = " + executeCodeResponse);
        return executeCodeResponse;
    }
}
