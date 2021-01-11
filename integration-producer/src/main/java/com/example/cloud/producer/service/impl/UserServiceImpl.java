package com.example.cloud.producer.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.cloud.pojo.entity.User;
import com.example.cloud.producer.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Override
	public List<User> findAll() {
		
		return null;
	}

}
