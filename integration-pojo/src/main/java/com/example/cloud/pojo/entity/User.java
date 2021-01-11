package com.example.cloud.pojo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Entity(name = "user")
@ToString
public class User {

	@Id
	private String id;

	@Column(name = "user_name", length=50)
	private String username;
	
	@Column(name = "password", nullable = false, length=50)
	private String password;
	
	@Column(name = "remark", nullable = false, length=50)
	private String remark;
	
}
