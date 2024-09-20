package com.dorneleduardo.pokemon.dto;


import java.util.List;




public record PokemonDTO( Long id,  String name ,  List<TypesDTO> types ,  int weight){

        public record TypesDTO(TypeName type){
        public record TypeName(String name){


        }

    }

}




















