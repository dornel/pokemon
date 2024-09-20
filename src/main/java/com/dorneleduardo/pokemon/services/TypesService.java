package com.dorneleduardo.pokemon.services;

import com.dorneleduardo.pokemon.dto.PokemonDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class TypesService {


    private final ObjectMapper typeMapper = new ObjectMapper();

    public String jsonToType(List<?> types) throws JsonProcessingException {

        String typeName = typeMapper.writeValueAsString(types);

        JsonNode rootNode = typeMapper.readTree(typeName);

        String typeFinal = rootNode.path(0).path("type").path("name").asText();


        return  typeFinal;

    }


}
