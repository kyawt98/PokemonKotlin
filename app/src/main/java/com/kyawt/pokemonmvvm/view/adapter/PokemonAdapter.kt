package com.kyawt.pokemonmvvm.view.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.pokemonmvvm.R
import com.kyawt.pokemonmvvm.service.model.PokemonX
import com.kyawt.pokemonmvvm.view.viewholders.PokemonViewHolder
import com.kyawt.pokemonmvvm.view.exts.bindView

class PokemonAdapter (private var clickListener: PokemonViewHolder.ClickListener,
                      private var pokeList:List<PokemonX> = emptyList()) : RecyclerView.Adapter<PokemonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(parent.context.bindView(R.layout.item_pokemon_list,parent),clickListener)
    }

    override fun getItemCount(): Int = pokeList.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokeList[position])
        Log.d("Image", pokeList.get(position).img)
    }

    fun updateList(pokeList: List<PokemonX>){
        this.pokeList = pokeList
        notifyDataSetChanged()
    }
}