package com.quiz.pokemon.controller;

import com.quiz.pokemon.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @CrossOrigin
@RequestMapping("pokemon/")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;
    @GetMapping("domande")
    public ResponseEntity<?> pokemons(){
        return ResponseEntity.ok(pokemonService.domande());
    }

}
