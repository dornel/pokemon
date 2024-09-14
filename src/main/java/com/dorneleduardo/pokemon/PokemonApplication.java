package com.dorneleduardo.pokemon;

import com.dorneleduardo.pokemon.models.PokemonModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import java.sql.SQLOutput;

@SpringBootApplication
public class PokemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonApplication.class, args);


		String url = "https://pokeapi.co/api/v2/pokemon/ditto";

		WebClient.Builder builder = WebClient.builder();

		String catFact = builder.build().get().uri(url).retrieve().bodyToMono(String.class).block();


		System.out.println("------------------------------------");
		System.out.println(catFact);
		System.out.println("------------------------------------");
	}






}
