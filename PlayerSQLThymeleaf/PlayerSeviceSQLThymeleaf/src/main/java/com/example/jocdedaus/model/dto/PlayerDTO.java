package com.example.jocdedaus.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PlayerDTO {
	private Long id;
	private String username;
	private LocalDateTime registrationDate;
	private Float percentatgedExit;
}
