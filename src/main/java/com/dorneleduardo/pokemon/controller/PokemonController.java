package com.dorneleduardo.pokemon.controller;

import com.dorneleduardo.pokemon.models.PokemonModel;
import com.dorneleduardo.pokemon.repository.PokemonRepository;
import com.dorneleduardo.pokemon.services.ExternalApiService;
import com.dorneleduardo.pokemon.services.PokemonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;



@RestController
public class PokemonController {

    private static final Logger logger = LoggerFactory.getLogger(PokemonController.class);


    @Autowired
    PokemonRepository pokemonRepository;
    @Autowired
    ExternalApiService externalApiService;
    @Autowired
    PokemonMapper pokemonMapper;



    @DeleteMapping("/pokemon/{name}")

    public ResponseEntity<String> deletePokemon(@PathVariable(value = "id") Long id){

        var pokemon1 = pokemonRepository.findById(id);

        if (pokemon1.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon with " + id + " not found in Pokedex!");

        }

        pokemonRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pokemon " + id + " deleted from Pokedex!");


    }



    @GetMapping("/pokemon")
    public ResponseEntity<List<PokemonModel>> getAllPokemons() {

        return ResponseEntity.status(HttpStatus.OK).body((pokemonRepository.findAll()));


    }


    @GetMapping("/pokemon/{name}")
    public ResponseEntity<Object> getOnePokemon(@PathVariable(value = "name") String name) throws IOException {


        if (pokemonRepository.findByName(name).isEmpty()){

            return ResponseEntity.status(HttpStatus.OK).body("Pokemon "+name+" not found in Pokedex!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.findByName(name));


    }


    @PostMapping("/pokemon/{name}")
    public ResponseEntity<Object> savePokemon(@PathVariable(value = "name") String name) throws IOException {

          var pokemon1 = externalApiService.getPokemon(name);
          var pokemon2 = pokemonMapper.dtoToEntity(pokemon1);

       BeanUtils.copyProperties(pokemon2,pokemonRepository);

       return ResponseEntity.status(HttpStatus.CREATED).body(pokemonRepository.save(pokemon2));


    }


    }


















