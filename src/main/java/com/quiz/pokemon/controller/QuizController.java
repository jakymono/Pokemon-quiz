package com.quiz.pokemon.controller;

import com.quiz.pokemon.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @CrossOrigin
@RequestMapping("domande/")
public class QuizController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("tipi")
    public ResponseEntity<?> getDomandeTipi(){
        return ResponseEntity.ok(pokemonService.domande());
    }
    @GetMapping("foto")
    public ResponseEntity<?> getDomandeFoto(){
        //To do
        return ResponseEntity.ok("");
    }
    @GetMapping("mix")
    public ResponseEntity<?> getDomandeMix(){
        //To do
        return ResponseEntity.ok("");
    }
}
