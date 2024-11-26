package com.example.myapplicationcoffee.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationcoffee.data.remote.model.Coffee
import com.example.myapplicationcoffee.utils.constantes.RetrofitClient
import kotlinx.coroutines.launch

class CoffeeViewModel : ViewModel() {
    var hotCoffees by mutableStateOf<List<Coffee>>(emptyList())
    var coldCoffees by mutableStateOf<List<Coffee>>(emptyList())

    init {
        fetchCoffees()
    }

    private fun fetchCoffees() {
        viewModelScope.launch {
            try {
                hotCoffees = RetrofitClient.coffeeApiService.getHotCoffees()
                coldCoffees = RetrofitClient.coffeeApiService.getColdCoffees()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}