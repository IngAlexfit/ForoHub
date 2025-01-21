package com.challenge.ForoHub.alura.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String nombre;
    private String correoElectronico;
}