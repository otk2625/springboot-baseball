package com.cos.baseball.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cos.baseball.model.BaseballStadium;
import com.cos.baseball.repository.BaseballStadiumRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BaseballStadiumService {

	private final BaseballStadiumRepository baseballStadiumRepository;
	
	public void save(BaseballStadium stadium) {
		baseballStadiumRepository.save(stadium);
	}

	@Transactional
	public List<BaseballStadium> findAll() {
		// TODO Auto-generated method stub
		return baseballStadiumRepository.findAll();
	}

	@Transactional
	public void 야구장삭제(int id) {
		baseballStadiumRepository.deleteById(id);
		
	}
	
}
