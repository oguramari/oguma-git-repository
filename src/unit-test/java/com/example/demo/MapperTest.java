package com.example.demo;

import com.example.demo.model.DemoUser;
import com.example.demo.repository.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper mapper;

    @Test /* 該当データありのケース. */
    public void test_userMapper01() throws ParseException {
        {
            DemoUser actual = mapper.selectOne("0001");
            assertEquals("0001",actual.getUserId());
            assertEquals("passw0rd",actual.getPassword());
            assertEquals("demoUser01",actual.getUserName());
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
            assertEquals(sdFormat.parse("1991-09-06"),actual.getBirthday());
            assertEquals(30,actual.getAge());
            assertEquals(1,actual.getGender());
            assertEquals(1,actual.getDepartmentId());
            assertEquals("ROLE_ADMIN",actual.getRole());
            assertEquals(1,actual.getDepartment().getDepartmentId());
            assertEquals("System management department",actual.getDepartment().getDepartmentName());
        }
    }

    @Test /* 該当データなしのケース. */
    public void test_userMapper02(){
        Optional<DemoUser> actual = Optional.ofNullable(mapper.selectOne("0000"));
        assertFalse(actual.isPresent());
    }
}