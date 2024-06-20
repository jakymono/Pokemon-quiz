package com.quiz.pokemon.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Domanda extends Training{

    private String foto;

    private List<String> risposte;
}
