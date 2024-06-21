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

    @GetMapping("{scelta}")
    public ResponseEntity<?> getDomande(@PathVariable int scelta){
        switch (scelta){
            case 1:
                return ResponseEntity.ok(pokemonService.domande());
            case 2:
                //to Do: get foto domande
                break;
            case 3:
                //to Do: get tipo/foto mix training
                break;
        }
        return new ResponseEntity<>("Errore: scelta non disponibile", HttpStatus.BAD_REQUEST);
    }

}
