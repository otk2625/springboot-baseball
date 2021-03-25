package com.cos.baseball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.model.BaseballStadium;
import com.cos.baseball.service.BaseballStadiumService;
import com.cos.baseball.util.Script;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BaseballStadiumController {
	
	private final BaseballStadiumService service;
	
	@GetMapping({"/", "/stadium"})
	public String main(Model model ) {
		
		model.addAttribute("stadiums", service.findAll());
		
		return "test/baseball/stadiummanage";
	}
	
	@GetMapping("/stadium/saveForm")
	public String saveForm() {
		return "test/baseball/stadiumSaveForm";
	}
	
	@DeleteMapping("/stadium/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		
		service.야구장삭제(id);
		System.out.println("삭제 완료");
		
		return "200";
	}
	
	@PostMapping("/stadium/save")
	public @ResponseBody String save(String name) {
		
		BaseballStadium stadium = new BaseballStadium();
		System.out.println("이름 : " + name);
		stadium.setName(name);
		
		service.save(stadium);
		
		return Script.href("성공", "/stadium");
	}
}
