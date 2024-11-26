package com.example.sweetbakery2

import com.google.firebase.firestore.PropertyName

// Product model class
data class Product(
    @PropertyName("name") val name: String = "",
    @PropertyName("price") val price: Double = 0.0,
    @PropertyName("imageBase64") val imageUrl: String = "" // Match Firestore field
)