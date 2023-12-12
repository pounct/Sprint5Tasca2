package com.example.jocdedaus.model.domain;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Player {
	private Long id;	
	private String username;
	private LocalDateTime registrationDate;
}
