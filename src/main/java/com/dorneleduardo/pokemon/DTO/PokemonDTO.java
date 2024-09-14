package com.dorneleduardo.pokemon.DTO;


import io.netty.util.internal.SocketUtils;
import jakarta.validation.constraints.NotNull;

public record PokemonDTO(@NotNull String name , @NotNull String type, @NotNull String weight){



}




















