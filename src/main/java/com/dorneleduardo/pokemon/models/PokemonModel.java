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
    private String types;
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

    public String getTypes() {
        return types;
    }

    public void setTypes(String type) {
        this.types = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setGender(String weight) {
        this.weight = weight;
    }
}
