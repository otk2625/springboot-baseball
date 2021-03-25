package com.cos.baseball.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.dto.PlayerSaveDto;
import com.cos.baseball.dto.PositionDto;
import com.cos.baseball.dto.TeamSaveDto;
import com.cos.baseball.model.Player;
import com.cos.baseball.model.Team;
import com.cos.baseball.repository.TeamRepository;
import com.cos.baseball.service.PlayerService;
import com.cos.baseball.util.Script;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {
	
	private final PlayerService playerService;
	private final TeamRepository teamRepository;
	
	@GetMapping("/player")
	public String main(Model model) {
		
		model.addAttribute("players", playerService.findAll());
		
		return "test/baseball/playermanage";
	}
	
	@GetMapping("/player/position")
	public String position(Model model) {
		
		List<String> lists = playerService.포지션별찾기();
		
		
		System.out.println("test1 : " + lists.get(0));
		String[] basemant1s = lists.get(0).split(",");
		
		System.out.println("test2 : " + lists.get(1));
		String[] basemant2s = lists.get(1).split(",");
		
		//System.out.println(lists);
		
		model.addAttribute("basemant1s", basemant1s);
		model.addAttribute("basemant2s", basemant2s);
		
		return "test/baseball/positionplayer";
	}
	
	
	@DeleteMapping("/player/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		
		playerService.선수삭제(id);
		System.out.println("삭제 완료");
		
		return "200";
	}
	
	@GetMapping("/player/saveForm")
	public String saveForm() {
		return "test/baseball/playerSaveForm";
	}
	
	@PostMapping("/player/save")
	public @ResponseBody String save(PlayerSaveDto playerSaveDto) {
		
		Player player = new Player();
		player.setName(playerSaveDto.getName());
		player.setPosition(playerSaveDto.getPosition());
		player.setTeam(teamRepository.findByName(playerSaveDto.getTeam()));
		
		playerService.save(player);
		
		return Script.href("성공", "/player");
	}
}

