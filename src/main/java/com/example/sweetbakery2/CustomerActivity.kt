package com.example.sweetbakery2

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.sweetbakery2.databinding.ActivityCustomerBinding
import com.example.sweetbakery2.viewmodel.CustomerViewModel
import com.google.firebase.auth.FirebaseAuth

class CustomerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomerBinding
    private val customerViewModel: CustomerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout with View Binding
        binding = ActivityCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Bind ViewModel to layout
        binding.lifecycleOwner = this
        binding.viewModel = customerViewModel

        // Observe LiveData for title
        customerViewModel.customerTitle.observe(this, Observer { title ->
            binding.tvCustomerTitle.text = title
        })

        // Button actions
        binding.btnMakeOrder.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java) // Update class name as needed
            startActivity(intent)
        }

        binding.btnUserManual.setOnClickListener {
            val intent = Intent(this, CustomerUserManualActivity::class.java)
            startActivity(intent)
        }

        binding.btnFAQ.setOnClickListener {
            val intent = Intent(this, FAQActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
