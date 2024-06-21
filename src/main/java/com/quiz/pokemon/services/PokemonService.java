package com.quiz.pokemon.services;

import com.quiz.pokemon.DTO.Training;
import com.quiz.pokemon.DTO.Domanda;
import com.quiz.pokemon.DTO.Training;
import com.quiz.pokemon.entity.FotoPokemon;
import com.quiz.pokemon.entity.Pokemon;
import com.quiz.pokemon.repository.FotoPokemonRepository;
import com.quiz.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.*;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private FotoPokemonRepository fotoPokemonRepository;

    String[] tipiPokemon = new String[] {
            "Water",
            "Fire",
            "Grass",
            "Electric",
            "Normal",
            "Flying",
            "Poison",
            "Ground",
            "Rock",
            "Bug",
            "Fighting",
            "Ghost",
            "Ice",
            "Dragon",
            "Steel",
            "Fairy",
            "Psychic",
            "Dark"
    };

    public List<Domanda> domande(){

        Random random = new Random();
        List<Pokemon> pokemons = pokemonRepository.findAll();
        List<FotoPokemon> fotoS= fotoPokemonRepository.findAll();
        List<Domanda> risp = new ArrayList<>();

        for(int i = 0 ; i < 30; i++){
            List<String> tipi = new ArrayList<>(Arrays.stream(tipiPokemon).toList());
            Domanda domanda = new Domanda();
            int numCasuale = random.nextInt(800);

            while(pokemons.get(numCasuale) == null){
                numCasuale++;
            }

            domanda.setPokemon(pokemons.get(numCasuale).getNome());
            domanda.setSoluzione(pokemons.get(numCasuale).getTipoPrimario());

            List<String> risposte = new ArrayList<>();

            risposte.add(pokemons.get(numCasuale).getTipoPrimario());
            tipi.remove(pokemons.get(numCasuale).getTipoPrimario());

            int num1 = random.nextInt(17);
            risposte.add(tipiPokemon[num1]);
            tipi.remove(num1);

            int num2 = random.nextInt(16);
            risposte.add(tipiPokemon[num2]);

            System.out.println(pokemons.get(numCasuale).getNome());
            String immagine = fotoPokemonRepository.findById(pokemons.get(numCasuale).getNome()).get().getImmagine();
            domanda.setFoto(immagine);

            Collections.shuffle(risposte);

            domanda.setRisposte(risposte);

            risp.add(domanda);
        }

        return risp;
    }

    public Training training(){

        Random random = new Random();
        List<Pokemon> pokemons = pokemonRepository.findAll();
        List<FotoPokemon> fotoS= fotoPokemonRepository.findAll();

        List<String> tipi = new ArrayList<>(Arrays.stream(tipiPokemon).toList());
        Domanda domanda = new Domanda();
        int numCasuale = random.nextInt(800);

        while(pokemons.get(numCasuale) == null){
            numCasuale++;
        }

        domanda.setPokemon(pokemons.get(numCasuale).getNome());
        domanda.setSoluzione(pokemons.get(numCasuale).getTipoPrimario());

        String immagine = fotoPokemonRepository.findById(pokemons.get(numCasuale).getNome()).get().getImmagine();
        domanda.setFoto(immagine);


        return domanda;
    }


}
