package com.example.cloud.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class UserVo {

	private String id;
	
	private String username;
	
	private String password;
	
	private String remark;
	
}
