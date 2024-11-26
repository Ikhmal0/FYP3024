package com.example.sweetbakery2

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class AdminUserManualActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.sweetbakery2.R.layout.activity_admin_user_manual) // Replace with your layout file

        // Initialize VideoView
        val videoView: VideoView = findViewById(com.example.sweetbakery2.R.id.videoView)

        // Set up MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Set video URI from raw resources
        val videoUri = Uri.parse("android.resource://${packageName}/raw/admin_user_manual")
        videoView.setVideoURI(videoUri)

        // Start playing the video
        videoView.start()

        // Find and set up the back button
        val backButton: Button = findViewById(com.example.sweetbakery2.R.id.btnBack)
        backButton.setOnClickListener {
            finish() // Close the activity and go back
        }
    }
}
