package cat.itacademy.Player.services;

import cat.itacademy.Player.entities.Player;

import java.util.List;
import java.util.Optional;

public class PlayerService {


   /* @Override
    public PlayerDTO addPlayer(PlayerDTO pdto) {
        Player player = playerRepository.save(PlayerMapper.toPlayer(pdto));
        return PlayerMapper.toDTO(player);
    }

    @Override
    public PlayerDTO updatePlayer(String nom, PlayerDTO playerDTO) {
        Optional<Player> player = playerRepository.findById(playerDTO.getId());
        if (player.isPresent()) {
            Player result = player.get();
            // only username can be changed for Player client
            result.setUsername(nom);
            playerRepository.save(result);
            return PlayerMapper.toDTO(result);
        }
        return null;
    }



    @Override
    public List<PlayerDTO> getAllPlayers() {

        List<Player> players = playerRepository.findAll();//PageRequest.of(0, 6)
        List<PlayerDTO> playersDTO = players.stream().map(PlayerMapper::toDTO).toList();
        playersDTO.forEach(p -> p.setPercentatgedExit(getPercentatge(p.getId())));
        return playersDTO;
    }


    @Override
    public Float getPercentatgeMitjaMitjor() {
        List<Player> players = playerRepository.findAll();
        float max = 0;
        for (Player p : players) {
            Float percent = getPercentatge(p.getId());
            if (percent > max) {
                max = percent;
            }
        }
        return max;
    }

    @Override
    public Float getPercentatgeMitjaPitjor() {
        List<Player> players = playerRepository.findAll();
        float min = 100;
        for (Player p : players) {
            Float percent = getPercentatge(p.getId());
            if (min > percent) {
                min = percent;
            }
        }
        return min;
    }

    @Override
    public List<String> getUsernames() {

        return playerRepository.findAll().stream().map(Player::getUsername).toList();
    }

    @Override
    public PlayerDTO getPlayerDTO(Long id) {

        Optional<Player> p = playerRepository.findById(id);
        if (p.isPresent()) {
            PlayerDTO dto = PlayerMapper.toDTO(p.get());
            dto.setPercentatgedExit(getPercentatge(id));
            return dto;
        }
        return null;
    }*/
}
