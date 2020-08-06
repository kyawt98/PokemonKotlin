package com.kyawt.pokemonmvvm.service.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PrevEvolution(
    @SerializedName("name")
    val name: String,
    @SerializedName("num")
    val num: String
): Parcelable