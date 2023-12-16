package com.d121211086.Minuman.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.d121211086.Minuman.data.repository.DrinkRepository
import com.d121211086.Minuman.data.source.remote.ApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val drinkRepository: DrinkRepository
}

class DefaultAppContainer: AppContainer {

    private val BASE_URL = "https://www.thecocktaildb.com/"
    val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val drinkRepository: DrinkRepository
        get() = DrinkRepository(retrofitService)

}