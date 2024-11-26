package com.example.sweetbakery2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    val name = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val role = MutableLiveData<String>()

    private val _registrationStatus = MutableLiveData<Result<String>>()
    val registrationStatus: LiveData<Result<String>> = _registrationStatus

    /**
     * Handles user registration and saving user data to Firestore.
     */
    fun registerUser(name: String, email: String, password: String, role: String) {
        // Validate input fields
        if (name.isBlank() || email.isBlank() || password.isBlank() || role.isBlank()) {
            _registrationStatus.value = Result.failure(Exception("All fields are required!"))
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val uid = FirebaseAuth.getInstance().currentUser?.uid
                    if (uid == null) {
                        _registrationStatus.value = Result.failure(Exception("User ID is null"))
                        return@addOnCompleteListener
                    }

                    val user = hashMapOf(
                        "name" to name,
                        "email" to email,
                        "role" to role
                    )

                    firestore.collection("Users").document(uid) // Use UID as document ID
                        .set(user)
                        .addOnSuccessListener {
                            _registrationStatus.value = Result.success("User registered successfully!")
                            Log.d("RegisterViewModel", "User saved to Firestore")
                        }
                        .addOnFailureListener { exception ->
                            _registrationStatus.value = Result.failure(exception)
                            Log.e("RegisterViewModel", "Error saving user to Firestore: ${exception.message}")
                        }
                } else {
                    _registrationStatus.value =
                        Result.failure(task.exception ?: Exception("Registration failed!"))
                    Log.e("RegisterViewModel", "Firebase Auth error: ${task.exception?.message}")
                }
            }
    }
}
