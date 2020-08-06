package com.kyawt.pokemonmvvm.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.kyawt.pokemonmvvm.R
import com.kyawt.pokemonmvvm.constants.BundleKey
import com.kyawt.pokemonmvvm.service.model.Pokemon
import com.kyawt.pokemonmvvm.service.model.PokemonX
import com.kyawt.pokemonmvvm.view.adapter.PokemonAdapter
import com.kyawt.pokemonmvvm.view.exts.logd
import com.kyawt.pokemonmvvm.view.viewholders.PokemonViewHolder
import com.kyawt.pokemonmvvm.viewmodel.PokemonDetailViewModel
import com.kyawt.pokemonmvvm.viewmodel.PokemonViewModel
import kotlinx.android.synthetic.main.fragment_pokemon_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PokemonListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokemonListFragment : Fragment(), PokemonViewHolder.ClickListener {

    lateinit var pokemonAdapter: PokemonAdapter
    lateinit var pokemonViewModel: PokemonViewModel


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_pokemon.apply {
            pokemonAdapter = PokemonAdapter(this@PokemonListFragment)
            this.adapter = pokemonAdapter
            this.layoutManager = GridLayoutManager(context, 2)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observeViewModel()
    }

    fun observeViewModel(){
        pokemonViewModel.getLoading().observe(this, Observer<Boolean> { isLoading ->
            Loading.visibility = if (isLoading) View.VISIBLE else View.INVISIBLE
            if (isLoading) {
                Loading.visibility = View.VISIBLE
                recycler_pokemon.visibility = View.GONE
            }
        })

        pokemonViewModel.loadResult().observe(this, Observer<Pokemon> { isResult ->
            Loading.visibility = View.GONE
            recycler_pokemon.visibility = View.VISIBLE
            pokemonAdapter.updateList(isResult.pokemon)
        })
    }

    override fun onClick(pokemon: PokemonX) {
        val targetFragment = PokemonDetailFragment.newInstance(pokemon)

        activity!!.supportFragmentManager
            .beginTransaction()
            .replace(R.id.screen_container,targetFragment)
            .addToBackStack(null)
            .commit()
    }
}