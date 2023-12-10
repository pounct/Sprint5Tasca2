package com.example.jocdedaus.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jocdedaus.model.domain.Player;

//@RepositoryRestResource(collectionResourceRel = "player", path = "player")
public interface PlayerRepository extends JpaRepository<Player, Long>{
}
