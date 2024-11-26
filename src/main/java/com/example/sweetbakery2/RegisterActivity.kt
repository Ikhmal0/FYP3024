package com.example.sweetbakery2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.sweetbakery2.databinding.ActivityRegisterBinding
import com.example.sweetbakery2.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout with Data Binding
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Bind ViewModel and LifecycleOwner
        binding.viewModel = registerViewModel
        binding.lifecycleOwner = this

        // Observe registration status
        registerViewModel.registrationStatus.observe(this, Observer { result ->
            result.fold(
                onSuccess = { message ->
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                    // Show the "Go to Login" button after successful registration
                    binding.btnGoToLogin.visibility = android.view.View.VISIBLE

                    // Debug log
                    Log.d("RegisterActivity", "Registration successful")
                },
                onFailure = { exception ->
                    Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
                }
            )
        })

        // Set up "Go to Login" button click
        binding.btnGoToLogin.setOnClickListener {
            // Debug log for button click
            Log.d("RegisterActivity", "Go to Login button clicked")
            navigateToLogin()
        }
    }

    /**
     * Navigates to LoginActivity.
     */
    private fun navigateToLogin() {
        Log.d("LoginActivity", "Navigating to LoginActivity")
        Toast.makeText(this, "Navigating to Login", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Close RegisterActivity so user can't go back to it
    }
}
