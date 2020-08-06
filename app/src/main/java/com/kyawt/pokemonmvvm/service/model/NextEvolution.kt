package com.kyawt.pokemonmvvm.service.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NextEvolution(
    @SerializedName("name")
    val name: String,
    @SerializedName("num")
    val num: String
): Parcelable