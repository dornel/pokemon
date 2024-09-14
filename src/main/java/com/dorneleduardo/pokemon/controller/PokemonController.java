package com.dorneleduardo.pokemon.controller;


import com.dorneleduardo.pokemon.DTO.PokemonDTO;
import com.dorneleduardo.pokemon.models.PokemonModel;
import com.dorneleduardo.pokemon.repository.PokemonRepository;
import com.dorneleduardo.pokemon.services.ExternalApiService;
import com.sun.tools.javac.Main;
import io.netty.util.internal.SocketUtils;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.apache.logging.slf4j.*;


@RestController
public class PokemonController {

    private static final Logger logger = LoggerFactory.getLogger(PokemonController.class);


    @Autowired
    PokemonRepository pokemonRepository;
    @Autowired
    ExternalApiService externalApiService;




    @PostMapping("/pokemon")

    public ResponseEntity<PokemonModel> savePokemon(@RequestBody PokemonDTO pokemonDTO){

        var pokemon1 = new PokemonModel();

        BeanUtils.copyProperties(pokemonDTO,pokemon1);

        return ResponseEntity.status(HttpStatus.CREATED).body(pokemonRepository.save(pokemon1));


    }
    @PutMapping("/pokemon/{id}")

    public ResponseEntity<PokemonModel> editPokemon(@PathVariable(value = "id") Long id,@RequestBody PokemonDTO pokemonDTO){

        var pokemon1 = pokemonRepository.findById(id);

        if (pokemon1.isEmpty()){

            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon " +id+ " not found in Pokedex");

        }

        var pokemonModel = pokemon1.get();
        BeanUtils.copyProperties(pokemonDTO,pokemonModel);
        return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.save(pokemonModel));


    }




    @GetMapping("/pokemon")
    public ResponseEntity<List<PokemonModel>> getAllPokemons() {

        return ResponseEntity.status(HttpStatus.OK).body((pokemonRepository.findAll()));


    }



    @GetMapping("/pokemon/{name}")
    public ResponseEntity<Object> getOnePokemon(@PathVariable(value = "name")String name) {

        var pokemon = externalApiService.getPokemon(name);


         return ResponseEntity.status(HttpStatus.OK).body(pokemon);


    }


  /*  @GetMapping("/pokemon/{id}")
    public ResponseEntity<Object> getOnePokemon(@PathVariable(value = "id")Long id) {

        var pokemon = pokemonRepository.findById(id);

        if (pokemon.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon with id: " + id + " not found");


        } return ResponseEntity.status(HttpStatus.OK).body(pokemon.get());


    }


   */

}











