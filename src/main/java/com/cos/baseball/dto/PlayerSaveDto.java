package com.cos.baseball.dto;

import com.cos.baseball.model.Team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlayerSaveDto {
	private String name;
	private String position;
	private String team;
}
