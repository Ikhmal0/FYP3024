package com.example.sweetbakery2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sweetbakery2.databinding.ActivityAddProductBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.io.InputStream

class AddProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddProductBinding
    private val PICK_IMAGE_REQUEST = 1
    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle image selection
        binding.btnUploadImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        // Handle Save Product button click
        binding.btnSaveProduct.setOnClickListener {
            val productName = binding.etProductName.text.toString().trim()
            val productPrice = binding.etProductPrice.text.toString().trim()

            if (productName.isEmpty() || productPrice.isEmpty()) {
                Toast.makeText(this, "Please enter product name and price", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (selectedImageUri != null) {
                saveProductToFirestore(selectedImageUri!!, productName, productPrice.toDouble())
            } else {
                Toast.makeText(this, "Please select an image", Toast.LENGTH_SHORT).show()
            }
        }

        // Find the back button
        val backButton: Button = findViewById(R.id.btnBack)

        // Set back button functionality
        backButton.setOnClickListener {
            finish() // Close the current activity and return to the previous one
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            selectedImageUri = data.data
            binding.ivProductImage.setImageURI(selectedImageUri)
        }
    }

    // Save product with Base64-encoded image to Firestore
    private fun saveProductToFirestore(imageUri: Uri, productName: String, productPrice: Double) {
        val base64Image = convertImageToBase64(imageUri)

        if (base64Image == null) {
            Toast.makeText(this, "Failed to process image", Toast.LENGTH_SHORT).show()
            return
        }

        val product = hashMapOf(
            "name" to productName,
            "price" to productPrice,
            "imageBase64" to base64Image // Save Base64 string instead of URL
        )

        val db = FirebaseFirestore.getInstance()
        db.collection("Products").document(productName) // Use productName as the document ID
            .set(product)
            .addOnSuccessListener {
                Toast.makeText(this, "Product added successfully", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error adding product: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    // Convert image to Base64
    private fun convertImageToBase64(imageUri: Uri): String? {
        return try {
            val inputStream: InputStream? = contentResolver.openInputStream(imageUri)
            val bytes = inputStream?.readBytes()
            inputStream?.close()
            Base64.encodeToString(bytes, Base64.DEFAULT)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
