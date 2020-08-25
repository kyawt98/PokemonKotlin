package com.kyawt.pokemonmvvm.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.kyawt.pokemonmvvm.service.model.PokemonX
import kotlinx.android.synthetic.main.item_pokemon_list.view.*

class PokemonViewHolder(val v:View ,
private val clickListener:ClickListener):  RecyclerView.ViewHolder(v) {
    fun bind(pokemon : PokemonX){
        v.txt_pokemon_name.text = pokemon.name
        Glide.with(v).load(pokemon.img)
            .listener(
                palette(pokemon.img,v.container)
            )
            .into(v.img_pokemon)

        v.rootView.setOnClickListener{
            clickListener.onClick(pokemon)
        }
    }

    private fun palette(url: String,view: View) = GlidePalette.with(url)
        .use(BitmapPalette.Profile.MUTED)
        .intoBackground(view)

    interface ClickListener{
        fun onClick(pokemon: PokemonX)
    }

}