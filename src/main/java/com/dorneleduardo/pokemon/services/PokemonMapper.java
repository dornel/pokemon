package com.dorneleduardo.pokemon.services;

import com.dorneleduardo.pokemon.dto.PokemonDTO;
import com.dorneleduardo.pokemon.models.PokemonModel;
import org.springframework.stereotype.Service;
import java.io.IOException;


@Service
public class PokemonMapper {

    public PokemonModel dtoToEntity(PokemonDTO dto) throws IOException {


        TypesService typesService = new TypesService() ;
        var pokemon1 = new PokemonModel();

        String typeName = typesService.jsonToType(dto.types());

        pokemon1.setName(dto.name());
        pokemon1.setTypes(typeName);
        pokemon1.setId(dto.id());
        pokemon1.setWeight(dto.weight());


        return pokemon1;

    }




}
