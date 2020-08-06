package com.kyawt.pokemonmvvm.service.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonX(
    @SerializedName("avg_spawns")
    val avgSpawns: String,
    @SerializedName("candy")
    val candy: String,
    @SerializedName("candy_count")
    val candyCount: String,
    @SerializedName("egg")
    val egg: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("multipliers")
    val multipliers: List<Double>,
    @SerializedName("name")
    val name: String,
    @SerializedName("next_evolution")
    val nextEvolution: List<NextEvolution>,
    @SerializedName("num")
    val num: String,
    @SerializedName("prev_evolution")
    val prevEvolution: List<PrevEvolution>,
    @SerializedName("spawn_chance")
    val spawnChance: Double,
    @SerializedName("spawn_time")
    val spawnTime: String,
    @SerializedName("type")
    val type: List<String>,
    @SerializedName("weaknesses")
    val weaknesses: List<String>,
    @SerializedName("weight")
    val weight: String
): Parcelable