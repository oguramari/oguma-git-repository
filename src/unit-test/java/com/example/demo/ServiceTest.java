package com.example.demo;

import com.example.demo.model.DemoUser;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
        DemoUser actual = service.doSelect("0001");
        assertEquals(expected, actual);
    }

    @Test /* 該当データなしのケース. */
    void test_doSelect02() {
        Optional<DemoUser> actual = Optional.ofNullable(service.doSelect("0000"));
            assertFalse(actual.isPresent());
    }
}