package com.dorneleduardo.pokemon.services;

import com.dorneleduardo.pokemon.dto.PokemonDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;



@Service
public class ExternalApiService {

    public ExternalApiService() {}

   public PokemonDTO getPokemon(String name){


       ExchangeStrategies strategies = ExchangeStrategies.builder()
               .codecs(configurer -> configurer
                       .defaultCodecs()
                       .maxInMemorySize(10 * 1024 * 1024))  // Aumenta o limite para 10 MB
               .build();


       WebClient.Builder builder = WebClient.builder().exchangeStrategies(strategies);

         return builder.build()
               .get()
               .uri("https://pokeapi.co/api/v2/pokemon/"+name)
               .retrieve()
                 .bodyToMono(PokemonDTO.class)
               .block();



   }






}
