package com.quiz.pokemon.repository;

import com.quiz.pokemon.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon,Integer> {

    @Query("select p.nome from Pokemon p where p.id = :idPokemon")
    Optional<String> getNomeByID(@Param("idPokemon")int id);

}
