package com.example.myapplicationcoffee.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationcoffee.data.remote.model.Coffee
import com.example.myapplicationcoffee.data.remote.repository.CoffeeRepository
import com.example.myapplicationcoffee.utils.constantes.RetrofitClient
import kotlinx.coroutines.launch

class CoffeeViewModel(
    private val repository: CoffeeRepository = CoffeeRepository(RetrofitClient.coffeeApiService)
) : ViewModel() {

    private val _hotCoffees = mutableStateOf<List<Coffee>>(emptyList())
    val hotCoffees: List<Coffee> get() = _hotCoffees.value

    init {
        fetchCoffees()
    }

    private fun fetchCoffees() {
        viewModelScope.launch {
            try {
                val hot = repository.getHotCoffees()
                Log.d("CoffeeViewModel", "Hot Coffees: $hot")
                _hotCoffees.value = hot

            } catch (e: Exception) {
                Log.e("CoffeeViewModel", "Error fetching coffees", e)
            }
        }
    }
}