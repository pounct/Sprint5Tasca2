package cat.itacademy.Player.web;

import cat.itacademy.Player.entities.Player;
import cat.itacademy.Player.repoitories.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class PlayerController {

    private PlayerRepository playerRepository;

    @GetMapping("/")
    public String home(Model model){
        return "home";
    }
    @GetMapping("/players")
    public String players(Model model){
        List<Player> playerList = playerRepository.findAll();
        model.addAttribute("players",playerList);
        return "players";
    }
    @GetMapping("/games")
    public String games(Model model){
        return "games";
    }

    @GetMapping("/auth")
    @ResponseBody
    public Authentication authentication(Authentication authentication){
        return authentication;
    }
}
