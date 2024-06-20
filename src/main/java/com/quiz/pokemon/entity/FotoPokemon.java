package com.quiz.pokemon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.context.annotation.Primary;

@Data
@Entity
@Table(name = "pokemon_pics")
public class FotoPokemon {

    @Id
    @Column(name = "nome")
    private String nome;

    @Column(name = "img")
    private String immagine;
}
