package com.example.cloud.consumer.controller;

import com.example.cloud.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud.consumer.service.UserService;
import com.example.cloud.pojo.model.Result;

@RestController
@RequestMapping("user")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public Result<?> list(){
		
		return new Result<>(Result.OK, "", userService.findAll());
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public Result<?> register(User user){

		return Result.create(Result.OK, "", userService.register(user));
	}

}
