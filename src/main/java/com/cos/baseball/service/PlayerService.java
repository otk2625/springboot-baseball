package com.cos.baseball.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cos.baseball.dto.PositionDto;
import com.cos.baseball.model.Player;
import com.cos.baseball.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {
	private final PlayerRepository playerRepository;

	@Transactional
	public void save(Player player) {
		playerRepository.save(player);
		
	}

	
	public List<Player> findAll() {
		
		return playerRepository.findAll();
	}

	@Transactional
	public void 선수삭제(int id) {
		playerRepository.deleteById(id);
		
	}


	public List<String>포지션별찾기() {
		// TODO Auto-generated method stub
		return playerRepository.findPositionPlayer();
	}

}
