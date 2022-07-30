package com.example.demo;

import com.example.demo.model.DemoUser;
import com.example.demo.repository.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper mapper;

    @Test /* 該当データありのケース. */
    public void test_userMapper01(){
        {
            DemoUser actual = mapper.selectOne("0001");
            assertEquals("0001",actual.getUserId());
            assertEquals("demoUser01",actual.getUserName());
            assertEquals(30,actual.getAge());
        }
    }

    @Test /* 該当データなしのケース. */
    public void test_userMapper02(){
        Optional<DemoUser> actual = Optional.ofNullable(mapper.selectOne("0000"));
        assertFalse(actual.isPresent());
    }
}