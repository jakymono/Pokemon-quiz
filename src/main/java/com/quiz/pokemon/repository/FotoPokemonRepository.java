package com.quiz.pokemon.repository;

import com.quiz.pokemon.entity.FotoPokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import java.util.Optional;

@Repository
public interface FotoPokemonRepository extends JpaRepository<FotoPokemon,String> {


    @Query(value = "select * from pokemon_pics f where f.name like '%:nome%'",nativeQuery = true)
    Optional<FotoPokemon> findByNomeLike(String nome);

}
