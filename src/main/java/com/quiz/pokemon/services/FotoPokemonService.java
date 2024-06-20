package com.quiz.pokemon.services;

import com.quiz.pokemon.repository.FotoPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoPokemonService {

    @Autowired
    private FotoPokemonRepository fotoPokemonRepository;

}
