package com.example.sweetbakery2.model

import com.google.firebase.firestore.PropertyName

data class Product(
    @PropertyName("name") val name: String = "",
    @PropertyName("price") val price: Double = 0.0,
    @PropertyName("image_url") val imageUrl: String = "" // Match Firestore field
)

data class Order(
    @PropertyName("email") val userEmail: String? = null,
    @PropertyName("productName") val productName: String? = null,
    @PropertyName("quantity") val quantity: Int = 0,
    @PropertyName("status") val status: String? = null
) {
    // Remove the default constructor unless it's required for some other purpose

}


data class Users(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val role: String = ""
)