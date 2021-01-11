package com.example.cloud.consumer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.cloud.consumer.repository.CardColourRepository;
import com.example.cloud.consumer.service.CardColourService;

@Service
@Transactional
public class CardColourServiceImpl implements CardColourService {

	@Autowired
	private CardColourRepository repository;
	
	@Override
	public Object addColour() {
		
		return null;
	}

}
