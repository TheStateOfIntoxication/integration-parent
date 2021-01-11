package com.example.cloud.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cloud.pojo.entity.Card;

public interface CardRepository extends JpaRepository<Card, String>{
	
}
