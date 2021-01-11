package com.example.cloud.pojo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="remanent")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Remanent {

	@Id
	private String id;
	
	@Column(name = "round_id", nullable = true, length=50)
	private String roundId;
	
	@Column(name = "card_id", nullable = true, length=50)
	private String cardId;
	
}
