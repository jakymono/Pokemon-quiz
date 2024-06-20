package com.quiz.pokemon.controller;

import com.quiz.pokemon.services.FotoPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FotoPokemonController {

    @Autowired
    private FotoPokemonService fotoPokemonService;

}
