package com.kyawt.pokemonmvvm.service.repository

import com.kyawt.pokemonmvvm.service.model.Pokemon
import com.kyawt.pokemonmvvm.service.model.PokemonX
import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {
    @GET("Biuni/PokemonGo-Pokedex/master/pokedex.json?fbclid=IwAR1O_LnnkhUjFdm8rd83l2hHc8qtjS-cvlOs92kuzXw9LoOsme6MUvltVEM")
    suspend fun getPokemon() :  Pokemon
}