package com.quiz.pokemon.services;

import com.quiz.pokemon.DTO.Domanda;
import com.quiz.pokemon.entity.Pokemon;
import com.quiz.pokemon.repository.FotoPokemonRepository;
import com.quiz.pokemon.repository.PokemonRepository;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private FotoPokemonRepository fotoPokemonRepository;

    String[] tipiPokemon = new String[] {
            "Acqua",
            "Fuoco",
            "Erba",
            "Elettrico",
            "Normale",
            "Volante",
            "Veleno",
            "Terra",
            "Roccia",
            "Insetto",
            "Lotta",
            "Spettro",
            "Ghiaccio",
            "Drago",
            "Acciaio",
            "Folletto",
            "Psico",
            "Buio"
    };

    public List<Domanda> domande(){

        Random random = new Random();
        List<Pokemon> pokemons = pokemonRepository.findAll();
        List<Domanda> risp = new ArrayList<>();

        for(int i = 0 ; i < 30; i++){
            List<String> tipi = new ArrayList<>(Arrays.stream(tipiPokemon).toList());
            Domanda domanda = new Domanda();
            int numCasuale = random.nextInt(800);

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

            String immagine = fotoPokemonRepository.findById(pokemons.get(numCasuale).getNome()).get().getImmagine();
            domanda.setFoto(immagine);

            domanda.setRisposte(risposte);

            risp.add(domanda);
        }

        return risp;
    }

}
