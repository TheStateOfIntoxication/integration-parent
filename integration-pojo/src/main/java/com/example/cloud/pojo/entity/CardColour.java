package com.example.cloud.pojo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="card_colour")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardColour {
	@Id
	private String id;
	@Column(name = "colour", nullable = true, length=5)
	private String colour;
}
