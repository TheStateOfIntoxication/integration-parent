package com.example.cloud.consumer.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.cloud.consumer.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cloud.consumer.repository.UserRepository;
import com.example.cloud.consumer.service.UserService;
import com.example.cloud.pojo.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public User register(User user) {
		user.setId(UUIDGenerator.getUuid());
		//userRepository.save(user);
		return null;
	}

	@Override
	public void deleteUser(String... ids) {
		List<String> idList = new ArrayList<>();
		for (String id : ids) {idList.add(id);}
		userRepository.deleteAll(userRepository.findByIdIn(idList));
	}


}
