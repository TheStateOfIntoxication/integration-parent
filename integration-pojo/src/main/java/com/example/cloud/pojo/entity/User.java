package com.example.cloud.pojo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.example.cloud.pojo.aop.annotations.Validation;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@Data
@Entity(name = "user")
@ToString
public class User {

	@Id
	@Validation
	private String id;

	@Column(name = "user_name", length=50)
	@Validation("^\\w{1,}$")
	private String username;
	
	@Column(name = "password", nullable = false, length=50)
	@Validation("^[\\w\\d_.]+$")
	private String password;
	
	@Column(name = "remark", nullable = false, length=50)
	private String remark;

	@Transient
	private List<User> userList;
	
}
