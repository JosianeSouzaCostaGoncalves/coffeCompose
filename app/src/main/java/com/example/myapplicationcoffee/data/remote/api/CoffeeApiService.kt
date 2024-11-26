package com.example.myapplicationcoffee.data.remote.api

import com.example.myapplicationcoffee.data.remote.model.Coffee
import retrofit2.http.GET

interface CoffeeApiService {
    @GET("coffee/hot")
    suspend fun getHotCoffees(): List<Coffee>

    @GET("coffee/cold")
    suspend fun getColdCoffees(): List<Coffee>
}