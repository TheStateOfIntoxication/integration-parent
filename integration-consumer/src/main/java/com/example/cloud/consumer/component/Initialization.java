package com.example.cloud.consumer.component;

import com.example.cloud.consumer.repository.CardRepository;
import com.example.cloud.consumer.utils.UUIDGenerator;
import com.example.cloud.pojo.entity.Card;
import com.example.cloud.pojo.utils.CardEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangR
 */
@Component
public class Initialization implements ApplicationRunner {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public void run(ApplicationArguments args) {
        List<Card> all = cardRepository.findAll();
        if (all.isEmpty()) {
            cardRepository.saveAll(getCards(1));
        }
    }

    private static List<Card> getCards(int num) {
        List<Card> list = new ArrayList<>();
        Card card;
        String str;
        // 少于14张牌
        int cardSize = 14;
        for (int k = 0; k < num; k ++) {
            for (int i = 1; i < cardSize; i++) {
                if (i == 1) {str = "A";}
                else if (i == 11) {str = "J";}
                else if (i == 12) {str = "Q";}
                else if (i == 13) {str = "K";}
                else {str = String.valueOf(i);}
                for (CardEnum cardEnum : CardEnum.values()) {
                    card = new Card();
                    card.setId(UUIDGenerator.getUuid())
                            .setColour(cardEnum.getColor())
                            .setFaces(str)
                            .setSpecial(false)
                            .setWeightCoefficient(i);
                    list.add(card);
                }
            }
            // 小王权重为 53, 大王权重为 54;
            int smallWeight = 53, bigWeight = 54;
            list.add(new Card(UUIDGenerator.getUuid(), "small", "", true, smallWeight));
            list.add(new Card(UUIDGenerator.getUuid(), "big", "", true, bigWeight));
        }
        return list;
    }










}
