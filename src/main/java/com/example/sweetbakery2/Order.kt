package com.example.sweetbakery2

data class Order(
    val customerEmail: String = "",
    val productName: String = "",
    val quantity: Int = 0,
    val status: String = ""
)