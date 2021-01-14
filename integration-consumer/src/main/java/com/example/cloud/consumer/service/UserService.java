package com.example.cloud.consumer.service;

import java.util.List;

import com.example.cloud.pojo.entity.User;



public interface UserService {
	
	List<User> findAll();

    User register(User user);

    void deleteUser(String... ids);
}
