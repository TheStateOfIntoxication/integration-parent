package com.example.cloud.consumer.component;

import com.example.cloud.consumer.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Initialization implements ApplicationRunner {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
