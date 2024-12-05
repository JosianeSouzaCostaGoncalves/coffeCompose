package com.example.myapplicationcoffee.data.remote.repository

import android.util.Log
import com.example.myapplicationcoffee.data.remote.api.CoffeeApiService
import com.example.myapplicationcoffee.data.remote.model.Coffee

class CoffeeRepository(private val apiService: CoffeeApiService) {

    suspend fun getHotCoffees(): List<Coffee> {
        return try {
            apiService.getHotCoffees().map {
                Coffee(
                    id = it.id,
                    name = it.name ?: "Nome não disponível",
                    description = it.description ?: "Descrição não disponível",
                    ingredients = it.ingredients ?: emptyList(),
                    image = it.image ?: "https://via.placeholder.com/150"
                )
            }
        } catch (e: Exception) {
            Log.e("CoffeeRepository", "Error fetching hot coffees", e)
            emptyList()
        }
    }

}