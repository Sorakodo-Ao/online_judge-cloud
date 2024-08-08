package com.caiwei.online_judge.checkComponent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
// 在任何Spring管理的类中
public class CheckComponentInjection {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 检测RemoteCodeSandBox是否被注入到Spring容器中
     */
    public void checkIfMyComponentIsInjected() {
        boolean isPresent = applicationContext.containsBean("remoteCodeSandBox");
        if (isPresent) {
            System.out.println("RemoteCodeSandBox is injected into the Spring container.");
        } else {
            System.out.println("RemoteCodeSandBox is NOT injected into the Spring container.");
        }
    }
}