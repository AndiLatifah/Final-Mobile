package com.d121211086.Minuman.data.repository

import com.d121211086.Minuman.data.response.GetDrinkResponse
import com.d121211086.Minuman.data.source.remote.ApiService

class DrinkRepository(private val apiService: ApiService) {

    suspend fun getDrinks(a: String): GetDrinkResponse {
        return apiService.getMinum(a)
    }

}