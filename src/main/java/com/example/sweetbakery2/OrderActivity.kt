package com.example.sweetbakery2

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sweetbakery2.databinding.ActivityOrderBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class OrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderBinding
    private val db = FirebaseFirestore.getInstance()
    private lateinit var products: List<Product> // List to hold products

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        db.collection("Products").get()
            .addOnSuccessListener { documents ->
                val products = documents.map { document ->
                    Product(
                        document.getString("name") ?: "",
                        document.getDouble("price") ?: 0.0,
                        document.getString("imageBase64") ?: "" // Use imageBase64 field
                    )
                }
                val adapter = ProductAdapter(products) { selectedProduct, position ->
                    // Fetch logged-in user's email
                    val currentUserEmail = FirebaseAuth.getInstance().currentUser?.email
                    if (currentUserEmail != null) {
                        val quantity = validateQuantity()
                        if (quantity != null) {
                            placeOrder(
                                userEmail = currentUserEmail, // Use actual user email
                                productName = selectedProduct.name,
                                quantity = quantity,
                                status = "Pending"
                            )
                        }
                    } else {
                        Toast.makeText(this, "User not logged in.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.recyclerView.adapter = adapter
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Failed to load products: ${e.message}", Toast.LENGTH_SHORT).show()
            }

        // Find the back button
        val backButton: Button = findViewById(R.id.btnBack)

        // Set back button functionality
        backButton.setOnClickListener {
            finish() // Close the current activity and return to the previous one
        }


    }

    private fun validateQuantity(): Int? {
        val quantityText = binding.etQuantity.text.toString().trim()
        return if (quantityText.isEmpty() || quantityText.toIntOrNull() == null || quantityText.toInt() <= 0) {
            Toast.makeText(this, "Please enter a valid quantity", Toast.LENGTH_SHORT).show()
            null
        } else {
            quantityText.toInt()
        }
    }

    private fun placeOrder(userEmail: String, productName: String, quantity: Int, status: String) {
        val userId = FirebaseAuth.getInstance().currentUser?.uid

        if (userId == null) {
            Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT).show()
            return
        }

        val order = hashMapOf(
            "customerEmail" to userEmail,
            "productName" to productName,
            "quantity" to quantity,
            "status" to status
        )

        val orderId = "$userEmail-$productName"
        db.collection("Orders").document(orderId) // Use a combination as document ID
            .set(order)
            .addOnSuccessListener {
                Toast.makeText(this, "Order placed successfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error placing order: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
