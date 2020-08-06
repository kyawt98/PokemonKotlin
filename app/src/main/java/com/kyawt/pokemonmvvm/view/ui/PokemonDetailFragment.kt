package com.kyawt.pokemonmvvm.view.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.kyawt.pokemonmvvm.R
import com.kyawt.pokemonmvvm.constants.BundleKey
import com.kyawt.pokemonmvvm.databinding.FragmentPokemonDetailBinding
import com.kyawt.pokemonmvvm.service.model.PokemonX
import com.kyawt.pokemonmvvm.view.exts.logd
import com.kyawt.pokemonmvvm.viewmodel.PokemonDetailViewModel
import kotlinx.android.synthetic.main.fragment_pokemon_detail.view.*
import kotlin.math.log


class PokemonDetailFragment : Fragment() {
    private lateinit var pokemonDetailViewModel : PokemonDetailViewModel

    private lateinit var viewBinding: FragmentPokemonDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pokemonDetailViewModel = ViewModelProviders.of(this).get(PokemonDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_pokemon_detail,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.apply {
            lifecycleOwner = this@PokemonDetailFragment
            viewmodel = pokemonDetailViewModel
        }

        val pokemon = arguments?.getParcelable<PokemonX>(BundleKey.DETAIL_KEY)
        pokemonDetailViewModel.setDetail(pokemon!!)
    }

    companion object {
        fun newInstance(pokemonX: PokemonX) = PokemonDetailFragment().also {
            logd("PokemonD_","$pokemonX")
            val bundle = Bundle()
            bundle.putParcelable(BundleKey.DETAIL_KEY,pokemonX)
            it.arguments = bundle

//            it.arguments?.putBundle(BundleKey.DETAIL_KEY,)
//            it.arguments?.putParcelable(BundleKey.DETAIL_KEY,pokemonX)
        }
    }

}