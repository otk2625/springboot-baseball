package com.cos.baseball.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BaseballStadium {
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Table, auto_increment, Sequence
	private int id;
	
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teamId")
	private Team team;
	
}
