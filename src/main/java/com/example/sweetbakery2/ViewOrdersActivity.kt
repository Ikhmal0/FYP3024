package com.example.sweetbakery2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sweetbakery2.OrderAdapter
import com.example.sweetbakery2.databinding.ActivityViewOrdersBinding
import com.example.sweetbakery2.model.Order
import com.google.firebase.firestore.FirebaseFirestore

class ViewOrdersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewOrdersBinding
    private val db = FirebaseFirestore.getInstance()
    private lateinit var orderAdapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding
        binding = ActivityViewOrdersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView and Adapter
        orderAdapter = OrderAdapter()
        binding.recyclerViewOrders.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewOrders.adapter = orderAdapter

        // Fetch orders from Firestore
        fetchOrders()

        // Find the back button
        val backButton: Button = findViewById(R.id.btnBack)

        // Set back button functionality
        backButton.setOnClickListener {
            finish() // Close the current activity and return to the previous one
        }
    }

    private fun fetchOrders() {
        db.collection("Orders").get()
            .addOnSuccessListener { documents ->
                val orderList = documents.mapNotNull { it.toObject(Order::class.java) }
                orderList.forEach { order ->
                    Log.d("Order", "Product Name: ${order.productName}")  // Log to check value
                }
                orderAdapter.submitList(orderList)
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Failed to load orders: ${e.message}", Toast.LENGTH_SHORT).show()
            }



    }


}
