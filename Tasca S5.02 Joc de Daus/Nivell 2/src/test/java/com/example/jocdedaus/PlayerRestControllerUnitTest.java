package com.example.jocdedaus;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.jocdedaus.controllers.PlayerRestController;
import com.example.jocdedaus.model.dto.PlayerDTO;
import com.example.jocdedaus.model.services.PlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(PlayerRestController.class)
class PlayerRestControllerUnitTest {
	
	@MockBean
    private PlayerService playerService;

    @Autowired 
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    
    @Test
    void shouldGetNoPlayers() throws Exception{
        List<PlayerDTO> players = new ArrayList<PlayerDTO>();
        when(playerService.getAllPlayers()).thenReturn(players);
        mockMvc.perform(get("/players"))
                .andExpect(status().isOk());
                
    }
    
    @Test
    void shouldCreatePlayer() throws Exception {
        
        PlayerDTO player = PlayerDTO.builder()
        		.username("player1")
        		.build();
        
        player.setRegistrationDate(LocalDateTime.now());

        mockMvc.perform(post("/players").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(player)))
                .andExpect(status().isOk());                
    }
    
     
    @Test
    void shouldGetTwoPlayers() throws Exception{

        PlayerDTO player = PlayerDTO.builder()
        		.username("player1")
        		.build();
        player.setRegistrationDate(LocalDateTime.now());
        PlayerDTO player2 = PlayerDTO.builder()
        		.username("player2")
        		.build();
        player.setRegistrationDate(LocalDateTime.now());

        List<PlayerDTO> players = new ArrayList<PlayerDTO>();
        players.add(player);
        players.add(player2);

        when(playerService.getAllPlayers()).thenReturn(players);
        mockMvc.perform(get("/players"))
                .andExpect(status().isOk());
                
    }
    
    @Test
    void shouldGetPlayerById() throws Exception{


    	PlayerDTO player = PlayerDTO.builder()
        		.username("player1")
        		.build();

        player.setId(1L);

        Optional<PlayerDTO> opt = Optional.of(player);

        assertThat(opt).isPresent();
        assertThat(opt.get().getId()).isEqualTo(player.getId());
        assertThat(player.getId()).isEqualTo(1);

        when(playerService.getPlayerDTO(player.getId())).thenReturn(opt.get());
        mockMvc.perform(get("/players/" + player.getId()))
                .andExpect(status().isOk());
                
    }

}
