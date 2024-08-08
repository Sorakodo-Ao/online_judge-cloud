package com.caiwei.online_judge;

import com.caiwei.online_judge.checkComponent.CheckComponentInjection;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class test {
    @Resource
    private CheckComponentInjection checkComponentInjection;

    @Test
    void test() {
    checkComponentInjection.checkIfMyComponentIsInjected();
    }
}
