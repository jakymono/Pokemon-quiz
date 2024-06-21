package com.quiz.pokemon.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class Training {

    @NotNull
    private String pokemon;
    private String soluzione;

    private String foto;

    public Training(String pokemon, String soluzione) {
        this.pokemon = pokemon;
        this.soluzione = soluzione;
    }
}
