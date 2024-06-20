package com.quiz.pokemon.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
    private Integer id;

    @Column(name = "pokedex")
    private int numPokedex;

    @Column(name = "name")
    private String nome;

    @Column(name = "type1")
    private String tipoPrimario;

    @Column(name = "type2")
    private String tipoSecondario;

    @Column(name = "total")
    private int totaleStats;

    @Column(name = "hp")
    private int ps;

    @Column(name = "attack")
    private int attacco;

    @Column(name = "defense")
    private int difesa;

    @Column(name = "spatk")
    private int attacoSpeciale;

    @Column(name = "spdef")
    private int difesaSpeciale;

    @Column(name = "speed")
    private int velocita;

    @Column(name = "generation")
    private int generazione;

    @Column(name = "legendary")
    private String leggendario;

}
