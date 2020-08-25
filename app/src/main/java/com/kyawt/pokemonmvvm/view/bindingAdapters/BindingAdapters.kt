package com.kyawt.pokemonmvvm.view.bindingAdapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import kotlinx.android.synthetic.main.fragment_pokemon_detail.view.*

@BindingAdapter(value = ["bindPokemonImage","bindContainer"])
fun bindImage(imageView: ImageView,url: String?,view: View){
    if (url != null){
        Glide.with(imageView.context)
            .load(url)
            .listener(
            GlidePalette.with(url)
                .use(BitmapPalette.Profile.VIBRANT)
                .intoBackground(view)
            )
            .into(imageView)
    }


}