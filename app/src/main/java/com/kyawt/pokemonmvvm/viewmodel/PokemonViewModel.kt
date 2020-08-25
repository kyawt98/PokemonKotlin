package com.kyawt.pokemonmvvm.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kyawt.pokemonmvvm.service.model.Pokemon
import com.kyawt.pokemonmvvm.service.model.PokemonX
import com.kyawt.pokemonmvvm.service.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonViewModel(application: Application) : AndroidViewModel(application){
    var loading : MutableLiveData<Boolean> = MutableLiveData()
    fun getLoading() : LiveData<Boolean> = loading

    val pokemonResult = MutableLiveData<Pokemon>()

    private var pokemonRepository : PokemonRepository = PokemonRepository()

    fun loadResult() {
        loading.value = true
        viewModelScope.launch {
            val result = pokemonRepository.getPokemon()
            pokemonResult.value = result
        }

    }
}