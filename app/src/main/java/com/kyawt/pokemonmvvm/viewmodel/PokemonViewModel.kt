package com.kyawt.pokemonmvvm.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kyawt.pokemonmvvm.service.model.Pokemon
import com.kyawt.pokemonmvvm.service.model.PokemonX
import com.kyawt.pokemonmvvm.service.repository.PokemonRepository

class PokemonViewModel(application: Application) : AndroidViewModel(application){
    var loading : MutableLiveData<Boolean> = MutableLiveData()
    fun getLoading() : LiveData<Boolean> = loading

    private var pokemonRepository : PokemonRepository = PokemonRepository()
    fun loadResult() : LiveData<Pokemon>{
        loading.value = true
        return pokemonRepository.getPokemon()
    }
}