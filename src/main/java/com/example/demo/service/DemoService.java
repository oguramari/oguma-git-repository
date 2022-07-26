package com.example.demo.service;

import com.example.demo.model.DemoUser;
import com.example.demo.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private UserMapper mapper;

    public DemoUser doSelect(String userId) {
        return mapper.selectOne(userId);
    }
}
