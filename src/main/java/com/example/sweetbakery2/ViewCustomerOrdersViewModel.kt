package com.example.sweetbakery2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sweetbakery2.model.Order
import com.google.firebase.firestore.FirebaseFirestore

class ViewCustomerOrdersViewModel : ViewModel() {

    private val _orders = MutableLiveData<List<Order>>()
    val orders: LiveData<List<Order>> get() = _orders

    private val firestore = FirebaseFirestore.getInstance()

    // Fetch orders for a specific user by email
    fun fetchCustomerOrders(userEmail: String) {
        firestore.collection("orders")
            .whereEqualTo("customerEmail", userEmail)
            .get()
            .addOnSuccessListener { documents ->
                if (documents.isEmpty) {
                    Log.d("ViewCustomerOrders", "No orders found for user: $userEmail")
                } else {
                    val ordersList = documents.mapNotNull { doc ->
                        doc.toObject(Order::class.java)
                    }
                    _orders.value = ordersList
                }
            }
            .addOnFailureListener { exception ->
                Log.e("ViewCustomerOrders", "Failed to fetch orders: ${exception.message}")
            }
    }

    // Fetch orders for the given email
    private fun fetchOrders(userEmail: String) {
        firestore.collection("orders")
            .whereEqualTo("customerEmail", userEmail) // Adjust field name if necessary
            .get()
            .addOnSuccessListener { orderDocuments ->
                val ordersList = orderDocuments.mapNotNull { doc ->
                    doc.toObject(Order::class.java)
                }
                _orders.value = ordersList
            }
            .addOnFailureListener { exception ->
                Log.e("ViewCustomerOrdersVM", "Error fetching orders: ${exception.message}")
            }
    }
}
