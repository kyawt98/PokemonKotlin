package com.kyawt.pokemonmvvm.service.model


import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("pokemon")
    val pokemon: List<PokemonX>
)