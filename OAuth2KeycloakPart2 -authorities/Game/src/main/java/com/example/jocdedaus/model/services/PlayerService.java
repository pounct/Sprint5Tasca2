package com.example.jocdedaus.model.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;
import com.example.jocdedaus.model.domain.Game;
import com.example.jocdedaus.model.domain.Player;
import com.example.jocdedaus.model.dto.GameDTO;
import com.example.jocdedaus.model.dto.PlayerDTO;
import com.example.jocdedaus.model.mappers.GameMapper;
import com.example.jocdedaus.model.mappers.PlayerMapper;
import com.example.jocdedaus.model.repositories.GameRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class PlayerService{


	private GameRepository gameRepository;

	static Random random() {
		return new Random();
	}

	//@Override
	public void deletePlayerGames(Long playerId) {

		List<Game> games = gameRepository.findAllByPlayerId(playerId);
		gameRepository.deleteAll(games);
	}

	//@Override
	public List<GameDTO> getPlayerGames(Long playerId) {

		return gameRepository.findAllByPlayerId(playerId).stream().map(GameMapper::toDTO).toList();
	}

	//@Override
	public Float getPercentatgeMitja() {
		List<Game> games = gameRepository.findAll();
		int won = 0;
		for (Game g : games) {
			if (Boolean.TRUE.equals(g.won())) {
				won++;
			}
		}
		return ((float) won * 100 / games.size());
	}

	//@Override
	public Float getPercentatge(Long id) {
		List<Game> games = gameRepository.findAllByPlayerId(id);
		int won = 0;
		for (Game g : games) {
			if (Boolean.TRUE.equals(g.won())) {
				won++;
			}
		}
		return ((float) won * 100 / games.size());
	}

	//@Override
	public GameDTO playGame(Long playerid) {
		// openfeign
		//Optional<Player> player = playerRepository.findById(playerid);
		//if (player.isPresent()) {

			Game game = new Game();
			game.setDice1((byte) (random().nextInt(6) + 1));
			game.setDice2((byte) (random().nextInt(6) + 1));
			game.setPlayerId(playerid);

			gameRepository.save(game);
			return GameMapper.toDTO(game);
		//}
		//return null;
	}

	//@Override
	public Float percentatgedExit(List<Game> playerGames) {
		Integer tiradesGuanyades = 0;
		if (!playerGames.isEmpty()) {
			for (Game t : playerGames) {
				if (Boolean.TRUE.equals(t.won())) {
					tiradesGuanyades += 1;
				}
			}
			return ((float) tiradesGuanyades / playerGames.size() * 100);
		}
		return null;
	}


}
