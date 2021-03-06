package com.example.cloud.consumer.controller;

import com.example.cloud.pojo.aop.annotations.Check;
import com.example.cloud.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cloud.consumer.service.UserService;
import com.example.cloud.pojo.model.Result;

/**
 * @author yangRan
 */
@RestController
@RequestMapping("user")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public Result<?> list(){
		
		return new Result<>(Result.OK, "", userService.findAll());
	}

	@Check
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public Result<?> register(@RequestBody User user){
		return Result.create(Result.OK, "", userService.register(user));
	}

}
