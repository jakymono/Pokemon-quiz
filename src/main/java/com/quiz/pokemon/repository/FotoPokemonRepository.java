package com.quiz.pokemon.repository;

import com.quiz.pokemon.entity.FotoPokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoPokemonRepository extends JpaRepository<FotoPokemon,String> {
}
