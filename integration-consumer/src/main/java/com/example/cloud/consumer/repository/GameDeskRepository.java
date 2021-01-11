package com.example.cloud.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cloud.pojo.entity.GameDesk;

public interface GameDeskRepository extends JpaRepository<GameDesk, String>{

}
