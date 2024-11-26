package com.example.sweetbakery2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class LoginViewModel : ViewModel() {

    private val _loginStatus = MutableLiveData<Boolean>()
    val loginStatus: LiveData<Boolean> get() = _loginStatus

    private val _userRole = MutableLiveData<String>()
    val userRole: LiveData<String> get() = _userRole

    // This method should authenticate the user
    fun loginUser(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // User authentication succeeded, check user role
                    val user = FirebaseAuth.getInstance().currentUser
                    if (user != null) {
                        val uid = user.uid
                        // Fetch user role from Firestore
                        FirebaseFirestore.getInstance().collection("Users").document(uid)
                            .get()
                            .addOnSuccessListener { document ->
                                val role = document.getString("role")
                                _userRole.value = role
                                _loginStatus.value = true
                            }
                            .addOnFailureListener {
                                // Error fetching role
                                _loginStatus.value = false
                            }
                    } else {
                        _loginStatus.value = false
                    }
                } else {
                    _loginStatus.value = false
                }
            }
    }
}
