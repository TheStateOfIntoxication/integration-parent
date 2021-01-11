package com.example.cloud.pojo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity(name = "card")
@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
	@Id
	private String id;
	
	@Column(name = "faces", nullable = true, length=10)
	private String faces;
	
	@Column(name = "colour_id", nullable = true, length=10)
	private String colourId;
	
	@Column(name = "special", nullable = true, length=10)
	private Boolean special;
	
	@Column(name = "weight_coefficient", nullable = true, length=10)
	private Integer weightCoefficient;
}
