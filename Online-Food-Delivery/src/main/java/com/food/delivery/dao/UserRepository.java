package com.food.delivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.delivery.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
