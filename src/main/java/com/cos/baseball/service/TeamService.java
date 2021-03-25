package com.cos.baseball.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cos.baseball.model.Team;
import com.cos.baseball.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamService {
	
	private final TeamRepository repository;

	public void save(Team team) {
		repository.save(team);
		
	}

	@Transactional
	public List<Team> findAll() {
		return repository.findAll();
	}

	@Transactional
	public void 팀삭제(int id) {
		repository.deleteById(id);
		
	}

}
