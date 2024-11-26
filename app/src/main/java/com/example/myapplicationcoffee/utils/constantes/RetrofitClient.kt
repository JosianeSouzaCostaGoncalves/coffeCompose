package com.example.myapplicationcoffee.utils.constantes

import com.example.myapplicationcoffee.data.remote.api.CoffeeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.sampleapis.com/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val coffeeApiService: CoffeeApiService = retrofit.create(CoffeeApiService::class.java)
}