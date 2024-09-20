package com.dorneleduardo.pokemon.configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI swaggerAPI(){



        return new OpenAPI().info(new Info().title("Pokemon API").version("1.0"));


    }




}
