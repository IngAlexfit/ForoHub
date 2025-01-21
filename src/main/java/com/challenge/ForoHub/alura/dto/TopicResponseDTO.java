package com.challenge.ForoHub.alura.dto;

import com.challenge.ForoHub.alura.model.Category;
import com.challenge.ForoHub.alura.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TopicResponseDTO {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private UserResponseDTO author;
    private Category category;



    @Data
    public static class UserResponseDTO {
        private Long id;
        private String nombre;
        private String correoElectronico;



    }
}