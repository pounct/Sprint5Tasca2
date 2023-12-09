package com.example.jocdedaus.controllers;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jocdedaus.model.dto.GameDTO;
import com.example.jocdedaus.model.dto.PlayerDTO;
import com.example.jocdedaus.model.services.PlayerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/web")
@AllArgsConstructor
public class PlayerController {
    private PlayerService playerService;
    
    @GetMapping("")
    public String home(){
        return "redirect:/web/players";
    }
    
    @GetMapping("/players")
    public String getPlayers(Model model, PlayerDTO player,
                        @RequestParam(name = "page",defaultValue = "0") int p,
                        @RequestParam(name = "size",defaultValue = "4")int s,
                        @RequestParam(name = "kw",defaultValue = "")String kw
                        ){
    	if (player==null) {
    		player=new PlayerDTO();
    		player.setUsername("ANONIMOUS");    		
    	}
    	
    	
        Page<PlayerDTO> pagePlayers=playerService.search(kw,p,s);
        for(PlayerDTO pl :pagePlayers) {
        	pl.setPercentatgedExit(playerService.getPercentatge(pl.getId()));
        }
        model.addAttribute("listPlayers",pagePlayers);
        model.addAttribute("pages",new int[pagePlayers.getTotalPages()]);
        model.addAttribute("currentPage",p);
        model.addAttribute("player",player);
        model.addAttribute("kw",kw);
        model.addAttribute("percentatgeMitja",playerService.getPercentatgeMitja());
        model.addAttribute("percentatgeMitjaMitjor",playerService.getPercentatgeMitjaMitjor());
        model.addAttribute("percentatgeMitjaPitjor",playerService.getPercentatgeMitjaPitjor());
        return "players";
    }
    
    @GetMapping("/addPlayer")
    public String formPlayer(Model model){

    	model.addAttribute("player",new PlayerDTO());
        return "formEditPlayer";
    }

    @GetMapping("/deletePlayer")
    public String delete(@RequestParam(
            name = "id") Long id,
                         @RequestParam(name = "keyword",defaultValue = "") String keyword,
                         @RequestParam(name = "page",defaultValue = "0") int page){
        playerService.deleteById(id);
        
        return "redirect:/web/players?page="+page+"&kw="+keyword;
    }    
    
    @PostMapping("/savePlayer")
    public String savePlayer(Model model,@Valid PlayerDTO player, BindingResult bindingResult){
    	
    	if(bindingResult.hasErrors()){
            return "formEditPlayer";
        }
    	String err = "";    	
    	String username = player.getUsername();
		List<String> usernames = playerService.getUsernames();
		if (usernames.contains(username) && (!username.contains("ANONIMOUS"))) {
			err = "username already exist!!";
			return "redirect:/web/addPlayer";
		}
		if (username == null || "".equals(username)) {
			
			player.setUsername("ANONYMOUS"+LocalDateTime.now());
		}
		player.setRegistrationDate(LocalDateTime.now());
		PlayerDTO playerDTOResult = playerService.addPlayer(player);
		model.addAttribute("player",playerDTOResult);
		
		return "confirmacio";
    }
    @GetMapping("/updatePlayer")
    public String updatePlayer(Model model, @RequestParam(name = "id") Long id){
    	
        PlayerDTO player= playerService.findById(id); 
        if (player==null) {
			return "formError";
        	}
        player.setPercentatgedExit(playerService.getPercentatge(player.getId()));
        //model.addAttribute("usernameNew","");//player.getUsername()
        model.addAttribute("player",player);
        System.out.println("updatePlayer"+player);
        return "formUpdatePlayer";
    }
    @PostMapping("/saveUpdatedPlayer")
    public String saveUpdatedPlayer(Model model,
    		@RequestParam(name = "usernameNew") String usernameNew, 
    		@RequestParam(name = "id") Long id){
    	
    	PlayerDTO player= playerService.findById(id); 
        if (player==null) {
			return "formError";
        	}
        player.setPercentatgedExit(playerService.getPercentatge(player.getId()));
    	System.out.println("saveUpdatedPlayer "+player);
    	System.out.println("usernameNew "+ usernameNew);
    	
    	if (usernameNew.equals(player.getUsername())) {
    		return "redirect:/web/players";
    	}
    	
		List<String> usernames = playerService.getUsernames();
		if (usernames.contains(usernameNew) ) { // && (!usernameNew.contains("ANONYMOUS"))
			//model.addAttribute("player",player);
			model.addAttribute("id",player.getId());
			System.out.println(usernameNew);
			//model.addAttribute("usernameNew",player.getUsername());
			//System.out.println(usernameNew);
			return "redirect:/web/updatePlayer?id="+id;			
		}
		
    	System.out.println("usernameNew "+ usernameNew);
    	System.out.println(player);
		if ("".equals(player.getUsername())) {
			
			player.setUsername("ANONYMOUS"+LocalDateTime.now());
		}
		else {
			player.setUsername(usernameNew);
		}
		System.out.println(usernameNew);
		System.out.println("saveUpdatedPlayer to save at \n"+player);
		PlayerDTO playerDTOResult = playerService.saveUpdatedPlayer(player);
		model.addAttribute("player",playerDTOResult);
		
		return "confirmacio";
    }
    
    
    @GetMapping("/getPlayer")
    public String getPlayer(Model model,
    		@RequestParam(name = "id") Long id,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "4") int s
                        ){
    	PlayerDTO player = playerService.getPlayerDTO(id);
        Page<GameDTO> gamesPlayers=playerService.searchGames(id,p,s);
        model.addAttribute("playerGames",gamesPlayers);
        model.addAttribute("pages",new int[gamesPlayers.getTotalPages()]);
        model.addAttribute("currentPage",p);
        model.addAttribute("player",player);
        return "playerGames";
    }
    @GetMapping("/playGames")
    public String playGames(Model model,
    		@RequestParam(name = "id") Long id,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "4") int s
                        ){
    	PlayerDTO player = playerService.getPlayerDTO(id);
    	GameDTO game = playerService.playGame(id);
        Page<GameDTO> gamesPlayers=playerService.searchGames(id,p,s);
        model.addAttribute("playerGames",gamesPlayers);
        model.addAttribute("pages",new int[gamesPlayers.getTotalPages()]);
        model.addAttribute("currentPage",p);
        model.addAttribute("player",player);
        return "playerGames";
    }
    @GetMapping("/deleteGames")
    public String deleteGames(Model model,
    		@RequestParam(name = "id") Long id,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "4") int s
                        ){
    	playerService.deletePlayerGames(id);
        Page<GameDTO> gamesPlayers=playerService.searchGames(id,p,s);
        model.addAttribute("playerGames",gamesPlayers);
        model.addAttribute("pages",new int[gamesPlayers.getTotalPages()]);
        model.addAttribute("currentPage",p);
        model.addAttribute("id",id);
        return "playerGames";
    }
}