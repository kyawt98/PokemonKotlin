package com.kyawt.pokemonmvvm.view.bindingAdapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_pokemon_detail.view.*

@BindingAdapter("bindPokemonImage")
fun bindImage(imageView: ImageView,url: String?){
    if (url != null){
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }

}