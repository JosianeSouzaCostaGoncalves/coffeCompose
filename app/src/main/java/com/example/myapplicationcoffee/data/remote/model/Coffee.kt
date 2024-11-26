package com.example.myapplicationcoffee.data.remote.model

data class Coffee(
    val id: Int,
    val name: String,
    val description: String,
    val ingredients: List<String>,
    val image: String
)