package com.example.sweetbakery2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sweetbakery2.adapter.OrderAdapter
import com.example.sweetbakery2.databinding.ActivityViewCustomerOrdersBinding
import com.example.sweetbakery2.viewmodel.ViewCustomerOrdersViewModel
import com.google.firebase.auth.FirebaseAuth

class ViewCustomerOrdersActivity : AppCompatActivity() {

    private val viewModel: ViewCustomerOrdersViewModel by viewModels()
    private lateinit var binding: ActivityViewCustomerOrdersBinding
    private val orderAdapter = OrderAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using View Binding
        binding = ActivityViewCustomerOrdersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        binding.rvCustomerOrders.layoutManager = LinearLayoutManager(this)
        binding.rvCustomerOrders.adapter = orderAdapter

        // Observe orders LiveData
        viewModel.orders.observe(this) { orders ->
            if (orders.isEmpty()) {
                Toast.makeText(this, "No orders found.", Toast.LENGTH_SHORT).show()
            }
            orderAdapter.submitList(orders)
        }

        // Fetch orders for the logged-in user
        val currentUserEmail = FirebaseAuth.getInstance().currentUser?.email
        if (currentUserEmail != null) {
            viewModel.fetchCustomerOrders(currentUserEmail)
        } else {
            Toast.makeText(this, "User not logged in.", Toast.LENGTH_SHORT).show()
        }
    }
}
