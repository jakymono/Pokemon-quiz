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

    @GetMapping("tipi")
    public ResponseEntity<?> getTrainingTipi(){
        //To do
        return ResponseEntity.ok("");
    }
    @GetMapping("foto")
    public ResponseEntity<?> getTrainingFoto(){
        return fotoPokemonService.getRandomTraining();
    }
    @GetMapping("mix")
    public ResponseEntity<?> getTrainingMix(){
        //To do
        return ResponseEntity.ok("");
    }
}
