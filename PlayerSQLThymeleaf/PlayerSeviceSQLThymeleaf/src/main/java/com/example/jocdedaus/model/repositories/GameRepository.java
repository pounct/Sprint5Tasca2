package com.example.jocdedaus.model.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.jocdedaus.model.domain.Game;
import com.example.jocdedaus.model.domain.Player;

//@RepositoryRestResource(collectionResourceRel = "game", path = "game")
public interface GameRepository extends JpaRepository<Game, Long> {
	
	//Iterable<? extends Long> findAllByPlayerID = null;

	List<Game> findAllByPlayerId(Long playerId);
	
	@Query("SELECT g FROM Game g WHERE g.player.id=:x")
	public Page<Game> searchGames(@Param("x") Long id, Pageable pageable);
}
