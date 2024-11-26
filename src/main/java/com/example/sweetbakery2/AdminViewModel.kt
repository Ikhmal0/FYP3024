package com.example.sweetbakery2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AdminViewModel : ViewModel() {

    // LiveData to observe admin title or any other info
    private val _adminTitle = MutableLiveData<String>()
    val adminTitle: LiveData<String> get() = _adminTitle

    init {
        // Set a default title for the Admin screen
        _adminTitle.value = "Admin Dashboard"
    }
}
