package com.example.myapplicationcoffee.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationcoffee.data.remote.model.Coffee
import com.example.myapplicationcoffee.data.remote.repository.CoffeeRepository
import com.example.myapplicationcoffee.utils.constantes.RetrofitClient
import kotlinx.coroutines.launch

class CoffeeViewModel(
    private val repository: CoffeeRepository = CoffeeRepository(RetrofitClient.coffeeApiService)
) : ViewModel() {

    private val _coffees = mutableStateOf<List<Coffee>>(emptyList())
    val coffees: List<Coffee> get() = _coffees.value

    init {
        fetchCoffees()
    }

    private fun fetchCoffees() {
        viewModelScope.launch {
            try {
                val coffee = repository.getCoffees()
                _coffees.value = coffee

            } catch (e: Exception) {
            }
        }
    }
}