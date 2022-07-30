package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class DemoUser {
    private String userId;
    private String password;
    private String userName;
    private Date birthday;
    private Integer age;
    private Integer gender;
    private Integer departmentId;
    private String role;
    private Department department;
}
