package com.quiz.pokemon.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Training {

    @NotNull
    private String pokemon;

    private String soluzione;

}
