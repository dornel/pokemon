package com.dorneleduardo.pokemon.repository;


import com.dorneleduardo.pokemon.models.PokemonModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonModel, Long> {

}
