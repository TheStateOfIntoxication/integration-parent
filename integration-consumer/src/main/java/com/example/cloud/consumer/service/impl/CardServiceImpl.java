package com.example.cloud.consumer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cloud.consumer.repository.CardRepository;
import com.example.cloud.consumer.repository.UserRepository;
import com.example.cloud.consumer.service.CardService;
import com.example.cloud.consumer.utils.UUIDGenerator;
import com.example.cloud.pojo.entity.Card;
import com.example.cloud.pojo.entity.GameDesk;
import com.example.cloud.pojo.entity.User;
import com.example.cloud.pojo.utils.CardUtil;

/**
 * @author yangR
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CardServiceImpl implements CardService {

	@Autowired
	private CardRepository cardRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addCard() {
		
	}

	@Override
	public Object beginGame() {
		//人数
		int peopleNum = 3;
		String resultString = "人数不对";
		List<User> users = userRepository.findAll();
		if (users.size() != peopleNum) {return resultString;}
		List<Card> cardList = cardRepository.findAll();
		CardUtil.wash(cardList);
		Map<String, List<Card>> dispense = CardUtil.dispense(cardList);
		String roundId = UUIDGenerator.getUuid();

		List<GameDesk> gameDeskList = new ArrayList<>();
		gameDeskList.addAll(getCardsByUser(roundId, users.get(0).getId(), dispense, "a"));
		gameDeskList.addAll(getCardsByUser(roundId, users.get(1).getId(), dispense, "b"));
		gameDeskList.addAll(getCardsByUser(roundId, users.get(2).getId(), dispense, "c"));

		return dispense;
	}
	
	private List<GameDesk> getCardsByUser(String roundId, String userId, Map<String, List<Card>> cardMap, String key){
		List<GameDesk> gameDeskList = new ArrayList<>();
		GameDesk gd;
		List<Card> aList = cardMap.get(key);
		int i = 0;
		for (Card card : aList) {
			gd = new GameDesk()
					.setId(UUIDGenerator.getUuid())
					.setRoundId(roundId)
					.setUserId(userId)
					.setCardId(card.getId())
					.setShowGrade(0)
					.setPreferentialRight(false)
					.setRoleId("2")
					.setLastId("")
					.setNextId("")
					.setOverFlag(false)
					.setSortFlag(++i);
			gameDeskList.add(gd);
		}
		return gameDeskList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
