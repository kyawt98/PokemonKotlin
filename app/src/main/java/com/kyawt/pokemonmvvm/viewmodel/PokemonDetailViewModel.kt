package com.kyawt.pokemonmvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kyawt.pokemonmvvm.service.model.PokemonX
import com.kyawt.pokemonmvvm.service.repository.PokemonRepository

class PokemonDetailViewModel(application: Application) : AndroidViewModel(application) {

    private var pokemonDetail : MutableLiveData<PokemonX> = MutableLiveData()
    val detailLiveData : LiveData<PokemonX>
    get() = pokemonDetail

    fun setDetail(pokemonX: PokemonX){
        pokemonDetail.value = pokemonX
    }

}