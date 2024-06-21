package com.quiz.pokemon.controller;

import com.quiz.pokemon.services.FotoPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("training/")
@CrossOrigin
public class TrainingController {

    @Autowired
    private FotoPokemonService fotoPokemonService;

    @GetMapping("{scelta}")
    public ResponseEntity<?> getRandomPokemon(@PathVariable int scelta){
        switch (scelta){
            case 1:
                //to Do: get tipo training
                break;
            case 2:
                return fotoPokemonService.getRandomTraining();
            case 3:
                //to Do: get tipo/foto mix training
                break;
        }
        return new ResponseEntity<>("Errore: scelta non disponibile", HttpStatus.BAD_REQUEST);
    }
}
