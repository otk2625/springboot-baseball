package com.cos.baseball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.dto.TeamSaveDto;
import com.cos.baseball.model.BaseballStadium;
import com.cos.baseball.model.Team;
import com.cos.baseball.repository.BaseballStadiumRepository;
import com.cos.baseball.service.BaseballStadiumService;
import com.cos.baseball.service.TeamService;
import com.cos.baseball.util.Script;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamController {

	private final TeamService teamService;
	private final BaseballStadiumRepository stadiumRepository;
	
	@GetMapping( "/team")
	public String main(Model model) {
		model.addAttribute("teams",teamService.findAll());
		
		return "test/baseball/teammanage";
	}
	
	@GetMapping("/team/saveForm")
	public String saveForm() {
		return "test/baseball/teamSaveForm";
	}
	
	@DeleteMapping("/team/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		
		teamService.팀삭제(id);
		System.out.println("삭제 완료");
		
		return "200";
	}
	
	@PostMapping("/team/save")
	public @ResponseBody String save(TeamSaveDto dto) {
		
		Team team = new Team();
		team.setName(dto.getName());
		
		BaseballStadium stadiumEntity = stadiumRepository.findByName(dto.getStadium());
		stadiumEntity.setTeam(team);
		
		
		team.setBaseballStadium(stadiumEntity);
		
		
		
		teamService.save(team);
		
		return Script.href("성공", "/team");
	}
}

