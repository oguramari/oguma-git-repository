package com.example.demo.repository;

import com.example.demo.model.DemoUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public DemoUser selectOne(String userId);
}
