package com.example.jocdedaus.model.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.jocdedaus.model.domain.Player;

@RepositoryRestResource(collectionResourceRel = "player", path = "player")
public interface PlayerRepository extends JpaRepository<Player, Long>{
	List<Player> findByUsername(String username);
	@Query("SELECT p FROM Player p WHERE p.username LIKE :x")
	Page<Player> search(@Param("x") String keyword, Pageable pageable);
}
