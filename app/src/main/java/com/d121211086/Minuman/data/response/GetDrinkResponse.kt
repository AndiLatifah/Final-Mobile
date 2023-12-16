package com.d121211086.Minuman.data.response

import kotlinx.serialization.Serializable
import com.d121211086.Minuman.data.models.Minum
import kotlinx.serialization.SerialName

@Serializable
class GetDrinkResponse(
    @SerialName("drinks")
    val drinks: List<Minum>?
)