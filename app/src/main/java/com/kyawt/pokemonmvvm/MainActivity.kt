package com.kyawt.pokemonmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kyawt.pokemonmvvm.view.ui.PokemonListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            val pokemonListFragment = PokemonListFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.screen_container, pokemonListFragment).commit()
        }
    }
}