package com.dorneleduardo.pokemon.services;

import com.dorneleduardo.pokemon.DTO.PokemonDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class ExternalApiService {

    public ExternalApiService() {}

   public PokemonDTO getPokemon(String name){

       WebClient.Builder builder = WebClient.builder();

         return builder.build()
               .get()
               .uri("https://pokeapi.co/api/v2/pokemon/"+name)
               .retrieve()
               .bodyToMono(PokemonDTO.class)
               .block();



   }






}
