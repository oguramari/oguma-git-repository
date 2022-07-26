package com.example.demo;

import com.example.demo.model.DemoUser;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServiceTest {

    @Autowired
    DemoService service;

    @Test /* 該当データありのケース. */
    void test_doSelect01() {
        DemoUser expected = new DemoUser();
        expected.setUserId("0001");
        expected.setUserName("demoUser01");
        expected.setAge(30);
        DemoUser result = service.doSelect("0001");
        assertEquals(expected, result);
    }

    @Test /* 該当データなしのケース. */
    void test_doSelect02() {
        DemoUser actual = service.doSelect("0000");
        assertEquals(null, actual);
    }
}