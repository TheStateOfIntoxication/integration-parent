package com.example.cloud.pojo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity(name="game_desk")
@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDesk {
	
	@Id
	private String id;
	
	@Column(name = "round_id", length=50)
	private String roundId;
	
	@Column(name = "user_id", length=11)
	private String userId;
	
	@Column(name = "card_id", length=11)
	private String cardId;
	
	@Column(name = "show_grade", length=5)
	private Integer showGrade;
	
	@Column(name = "preferential_right", length=5)
	private Boolean preferentialRight;
	
	@Column(name = "role_id", length=11)
	private String roleId;
	
	@Column(name = "last_id", length=50)
	private String lastId;
	
	@Column(name = "next_id", length=50)
	private String nextId;
	
	@Column(name = "over_flag", length=50)
	private Boolean overFlag;
	
	@Column(name = "sort_flag", length=50)
	private Integer sortFlag; 
	
}
