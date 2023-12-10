package com.example.jocdedaus.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jocdedaus.model.domain.Game;

//@RepositoryRestResource(collectionResourceRel = "game", path = "game")
public interface GameRepository extends JpaRepository<Game, Long> {
	
	List<Game> findAllByPlayerId(Long playerId);
}
