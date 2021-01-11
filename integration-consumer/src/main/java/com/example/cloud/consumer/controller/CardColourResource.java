package com.example.cloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud.consumer.service.CardColourService;

@RestController
@RequestMapping("cardColour")
public class CardColourResource {
	
	@Autowired
	private CardColourService service;
	
	@RequestMapping(value="addColour", method = RequestMethod.GET)
	public Object addColour(){
		return service.addColour();
	}
}
