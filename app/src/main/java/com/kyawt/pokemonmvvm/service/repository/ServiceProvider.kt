package com.kyawt.pokemonmvvm.service.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceProvider {
    companion object{
        const val BASE_URL ="https://raw.githubusercontent.com/"

        fun getService() : PokemonService{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(PokemonService::class.java)
        }
    }
}