package com.cos.baseball.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.baseball.model.BaseballStadium;

public interface BaseballStadiumRepository extends JpaRepository<BaseballStadium, Integer>{
	
	BaseballStadium findByName(String name);
}
