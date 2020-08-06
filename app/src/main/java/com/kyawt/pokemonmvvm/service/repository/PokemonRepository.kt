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
    fun getPokemon():LiveData<Pokemon>{
        val service = ServiceProvider.getService()
        val data : MutableLiveData<Pokemon> = MutableLiveData()
        service.getPokemon().enqueue(object : Callback<Pokemon>{
            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                Log.d("Error", t.toString())
            }

            override fun onResponse(
                call: Call<Pokemon>,
                response: Response<Pokemon>
            ) {
                data.value = Pokemon(response.body()?.pokemon?: emptyList())
            }
        })

        return data
    }
}