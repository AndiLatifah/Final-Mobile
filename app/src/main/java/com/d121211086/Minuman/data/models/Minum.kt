package com.d121211086.Minuman.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Minum(
    val strDrink: String?,
    val strDrinkThumb: String?,
    val idDrink: String?
) : Parcelable