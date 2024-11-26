package com.example.sweetbakery2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

class AddProductViewModel : ViewModel() {

    val productName = MutableLiveData<String>()
    val productPrice = MutableLiveData<String>()
    val productImageUri = MutableLiveData<String>()

    // For communicating success or failure to the UI
    val isProductAdded = MutableLiveData<Boolean>()

    private val db = FirebaseFirestore.getInstance()

    // Function to save product to Firestore
    fun saveProduct(productName: String, productPrice: Double, imageUrl: String) {
        val product = hashMapOf(
            "name" to productName,
            "price" to productPrice,
            "imageUrl" to imageUrl
        )

        db.collection("Products")
            .add(product)
            .addOnSuccessListener {
                // Notify UI that the product was successfully added
                isProductAdded.value = true
            }
            .addOnFailureListener { e ->
                // Notify UI of failure
                isProductAdded.value = false
            }
    }
}
