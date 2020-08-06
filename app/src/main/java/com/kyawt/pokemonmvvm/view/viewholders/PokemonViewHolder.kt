package com.kyawt.pokemonmvvm.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kyawt.pokemonmvvm.service.model.PokemonX
import kotlinx.android.synthetic.main.item_pokemon_list.view.*

class PokemonViewHolder(val v:View ,
private val clickListener:ClickListener):  RecyclerView.ViewHolder(v) {
    fun bind(pokemon : PokemonX){
        v.txt_pokemon_name.text = pokemon.name
        Glide.with(v).load(pokemon.img)
            .into(v.img_pokemon)

        v.rootView.setOnClickListener{
            clickListener.onClick(pokemon)
        }
    }

    interface ClickListener{
        fun onClick(pokemon: PokemonX)
    }

}