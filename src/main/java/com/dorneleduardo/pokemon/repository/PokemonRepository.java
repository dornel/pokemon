package com.dorneleduardo.pokemon.repository;


import com.dorneleduardo.pokemon.models.PokemonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonModel, Long>  {

    List<?> findByName(String name);

}
