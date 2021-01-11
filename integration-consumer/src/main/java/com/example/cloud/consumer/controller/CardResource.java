package com.example.cloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.cloud.consumer.service.CardService;

@RestController
@RequestMapping("card")
public class CardResource {
	
	@Autowired
	private CardService cardService;

	@RequestMapping(value="test", method = RequestMethod.GET)
	public void addCard(){
		cardService.addCard();
	}
	
	@RequestMapping(value="beginGame", method = RequestMethod.POST)
	public Object beginGame(){
		
		return cardService.beginGame();
	}
	
}
