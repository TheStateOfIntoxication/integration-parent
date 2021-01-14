package com.example.cloud.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cloud.pojo.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, String>{

    List<User> findByIdIn(Collection<String> c);

}
