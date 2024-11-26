package com.example.sweetbakery2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.sweetbakery2.databinding.ActivityAdminBinding
import com.example.sweetbakery2.viewmodel.AdminViewModel
import com.google.firebase.auth.FirebaseAuth

class AdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminBinding
    private val adminViewModel: AdminViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout with ViewBinding
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observe the admin title from the ViewModel (if you want to set a title dynamically)
        adminViewModel.adminTitle.observe(this, { title ->
            binding.tvAdminTitle.text = title
        })

        // Set click listeners for buttons
        binding.btnAddProduct.setOnClickListener {
            val intent = Intent(this, AddProductActivity::class.java)
            startActivity(intent)
        }

        binding.btnViewOrders.setOnClickListener {
            val intent = Intent(this, ViewOrdersActivity::class.java)
            startActivity(intent)
        }

        binding.btnUserManual.setOnClickListener {
            val intent = Intent(this, AdminUserManualActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {
            // Log out logic using Firebase Auth
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Close the AdminActivity after logging out
        }
    }
}
