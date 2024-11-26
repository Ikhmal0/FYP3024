package com.example.sweetbakery2

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FAQActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faqactivity) // Replace with your layout file

        // Find the back button
        val backButton: Button = findViewById(R.id.btnBack)

        // Set back button functionality
        backButton.setOnClickListener {
            finish() // Close the current activity and return to the previous one
        }
    }
}
