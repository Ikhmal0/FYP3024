package com.example.sweetbakery2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.sweetbakery2.databinding.ActivityLoginBinding
import com.example.sweetbakery2.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bind layout with data binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set ViewModel and lifecycleOwner
        binding.viewModel = loginViewModel
        binding.lifecycleOwner = this

        // Observe login status from ViewModel
        loginViewModel.loginStatus.observe(this) { isSuccess ->
            if (isSuccess) {
                // Observe user role and navigate to respective activity
                loginViewModel.userRole.observe(this) { role ->
                    if (role == "admin") {
                        // Admin role - navigate to AdminActivity
                        startActivity(Intent(this, AdminActivity::class.java))
                    } else {
                        // Customer role - navigate to CustomerActivity
                        startActivity(Intent(this, CustomerActivity::class.java))
                    }
                    finish()
                }
            } else {
                // Login failed
                Toast.makeText(this, "Login Failed. Try again.", Toast.LENGTH_SHORT).show()
            }
        }

        // Handle Login button click
        binding.btnLogin.setOnClickListener {
            val email = binding.eTEmail.text.toString().trim()
            val password = binding.eTPassword.text.toString().trim()

            // Validate email and password
            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginViewModel.loginUser(email, password)
            } else {
                Toast.makeText(this, "Please enter valid email and password", Toast.LENGTH_SHORT).show()
            }
        }

        // Handle Register button click
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java)) // Redirect to RegisterActivity
        }
    }
}
