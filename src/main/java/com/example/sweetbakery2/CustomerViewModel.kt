package com.example.sweetbakery2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sweetbakery2.model.Order
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class CustomerViewModel : ViewModel() {

    private val firestore = FirebaseFirestore.getInstance()

    // LiveData for the dashboard title
    private val _customerTitle = MutableLiveData("Welcome To Sweet Bakery")
    val customerTitle: LiveData<String> get() = _customerTitle

    // LiveData for orders
    private val _orders = MutableLiveData<List<Order>>()
    val orders: LiveData<List<Order>> get() = _orders

    init {
        fetchOrders() // Fetch all orders on initialization
    }

    /**
     * Updates the title dynamically.
     * @param newTitle The new title for the dashboard.
     */
    fun updateTitle(newTitle: String) {
        _customerTitle.value = newTitle
    }

    /**
     * Fetches all customer orders from Firestore.
     */
    fun fetchOrders() {
        firestore.collection("orders")
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { documents ->
                val ordersList = documents.mapNotNull { doc ->
                    doc.toObject(Order::class.java)
                }
                _orders.value = ordersList
            }
            .addOnFailureListener {
                // Handle failure if needed
            }
    }
}
