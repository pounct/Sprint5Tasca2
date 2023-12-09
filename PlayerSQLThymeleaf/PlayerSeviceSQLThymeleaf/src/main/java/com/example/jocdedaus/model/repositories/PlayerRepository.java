package com.example.jocdedaus.model.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.jocdedaus.model.domain.Player;

//@RepositoryRestResource(collectionResourceRel = "player", path = "player")
public interface PlayerRepository extends JpaRepository<Player, Long>{	

	//Page<Player> findByUsernameContains(String keyword, Pageable pageable);
	
	@Query("SELECT p FROM Player p WHERE p.username LIKE :x")
	public Page<Player> search(@Param("x") String keyword, Pageable pageable);
}
