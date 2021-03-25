package com.cos.baseball.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Team {
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Table, auto_increment, Sequence
	private int id;
	
	private String name;
	
	@OneToOne
	@JoinColumn(name = "baseballStadiumId")
	private BaseballStadium baseballStadium;
	
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private List<Player> players;
}
