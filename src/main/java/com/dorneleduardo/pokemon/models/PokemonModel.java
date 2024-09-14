package com.dorneleduardo.pokemon.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Pokemon")
public class PokemonModel implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String weight;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setGender(String weight) {
        this.weight = weight;
    }
}
