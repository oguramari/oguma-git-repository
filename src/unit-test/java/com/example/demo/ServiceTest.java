package com.example.demo;

import com.example.demo.model.DemoUser;
import com.example.demo.model.Department;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class ServiceTest {

    @Autowired
    DemoService service;

    @Test /* 該当データありのケース. */
    void test_doSelect01() throws ParseException {
        DemoUser expected = new DemoUser();
        expected.setUserId("0001");
        expected.setPassword("passw0rd");
        expected.setUserName("demoUser01");
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
        expected.setBirthday(sdFormat.parse("1991-09-06"));
        expected.setAge(30);
        expected.setGender(1);
        expected.setDepartmentId(1);
        Department department = new Department();
        department.setDepartmentId(1);
        expected.setRole("ROLE_ADMIN");
        department.setDepartmentName("System management department");
        expected.setDepartment(department);
        DemoUser actual = service.doSelect("0001");
        assertEquals(expected, actual);
    }

    @Test /* 該当データなしのケース. */
    void test_doSelect02() {
        Optional<DemoUser> actual = Optional.ofNullable(service.doSelect("0000"));
        assertFalse(actual.isPresent());
    }
}