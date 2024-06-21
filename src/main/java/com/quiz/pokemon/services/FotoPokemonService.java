package com.quiz.pokemon.services;

import com.quiz.pokemon.DTO.Domanda;
import com.quiz.pokemon.DTO.Training;
import com.quiz.pokemon.entity.FotoPokemon;
import com.quiz.pokemon.repository.FotoPokemonRepository;
import com.quiz.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class FotoPokemonService {

    @Autowired
    private FotoPokemonRepository fotoPokemonRepository;
    @Autowired
    private PokemonRepository pokemonRepository;

    public ResponseEntity<?> getRandomTraining(){
        int maxPokemon = 800;

        Random random = new Random();
        String nomePokemon = "";
        do {
            Optional<String> optionalPokemon = pokemonRepository.getNomeByID(random.nextInt(maxPokemon));
            if (optionalPokemon.isPresent()){
                nomePokemon = optionalPokemon.get();
            }
        }while(nomePokemon=="");

        Optional<FotoPokemon> fotoOptional = fotoPokemonRepository.findById(nomePokemon);
        if(fotoOptional.isEmpty()){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Training training = new Training(fotoOptional.get().getImmagine(),nomePokemon);
        return new ResponseEntity(training,HttpStatus.OK);

    }

}
