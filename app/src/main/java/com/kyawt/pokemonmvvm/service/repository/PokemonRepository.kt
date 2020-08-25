package com.kyawt.pokemonmvvm.service.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kyawt.pokemonmvvm.service.model.Pokemon
import com.kyawt.pokemonmvvm.service.model.PokemonX
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepository {
    suspend fun getPokemon(): Pokemon{
        val service = ServiceProvider.getService()
        return  service.getPokemon()
    }
}