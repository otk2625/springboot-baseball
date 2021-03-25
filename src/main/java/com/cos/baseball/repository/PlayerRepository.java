package com.cos.baseball.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.baseball.dto.PositionDto;
import com.cos.baseball.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

	@Query(value = "SELECT position, "
			+ "	GROUP_CONCAT(if(team ='롯데', name,NULL)) as '롯데', "
			+ "    GROUP_CONCAT(if(team ='NC', name,NULL)) as  'NC', "
			+ "    GROUP_CONCAT(if(team ='기아', name,NULL)) as  '기아', "
			+ "    GROUP_CONCAT(if(team ='해태', name,NULL)) as  '해태' "
			+ "FROM "
			+ "(select p.name as name, p.position as position, t.name as team "
			+ "from player p inner join team t\r\n"
			+ "on p.teamId = t.id "
			+ ") z "
			+ "group by position ", nativeQuery = true)
	List<String> findPositionPlayer();

}
