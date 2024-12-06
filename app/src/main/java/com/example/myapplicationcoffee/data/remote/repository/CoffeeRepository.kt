package com.example.myapplicationcoffee.data.remote.repository

import com.example.myapplicationcoffee.data.remote.api.CoffeeApiService
import com.example.myapplicationcoffee.data.remote.model.Coffee

class CoffeeRepository(private val apiService: CoffeeApiService) {

    suspend fun getCoffees(): List<Coffee> {
        return try {
            apiService.getCoffees().map {
                Coffee(
                    id = it.id,
                    title = it.title ?: "Nome não disponível",
                    description = it.description ?: "Descrição não disponível",
                    ingredients = it.ingredients ?: emptyList(),
                    image = it.image ?: "https://via.placeholder.com/150"
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

}