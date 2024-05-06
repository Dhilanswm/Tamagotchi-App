package com.eddy.tamagotchiapp7

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    // Variables to track pet's status
    var health = 0
    var hunger = 0
    var cleanliness = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        // Initialize views
        val petImageView: ImageView = findViewById(R.id.petImageView)
        val feedButton: Button = findViewById(R.id.feedButton)
        val cleanButton: Button = findViewById(R.id.cleanButton)
        val playButton: Button = findViewById(R.id.playButton)
        val healthTextView: TextView = findViewById(R.id.healthTextView)
        val hungerTextView: TextView = findViewById(R.id.hungerTextView)
        val cleanlinessTextView: TextView = findViewById(R.id.cleanlinessTextView)

        // Set initial pet image and status values
        updatePetStatus(health, hunger, cleanliness)

        // Set onClickListener for Feed button
        feedButton.setOnClickListener {
            // Update pet image and status values for feeding action
            petImageView.setImageResource(R.drawable.dog_eating)
            hunger+=10 // Adjust hunger level
                      // Ensure hunger doesn't go below 0
            updatePetStatus(health, hunger, cleanliness)
        }

        // Set onClickListener for Clean button
        cleanButton.setOnClickListener {
            // Update pet image and status values for cleaning action
            petImageView.setImageResource(R.drawable.bathing_dog)
            cleanliness+=10 // Reset cleanliness level
            updatePetStatus(health, hunger, cleanliness)
        }

        // Set onClickListener for Play button
        playButton.setOnClickListener {
            // Update pet image and status values for playing action
            petImageView.setImageResource(R.drawable.dog_playing)
             health+=10  // Implement play logic here
            updatePetStatus(health, hunger, cleanliness)
        }
    }

    // Function to update pet's status values and display them
    private fun updatePetStatus(health: Int, hunger: Int, cleanliness: Int) {
        val healthTextView: TextView = findViewById(R.id.healthTextView)
        val hungerTextView: TextView = findViewById(R.id.hungerTextView)
        val cleanlinessTextView: TextView = findViewById(R.id.cleanlinessTextView)

        healthTextView.text = "Health: $health"
        hungerTextView.text = "Hunger: $hunger"
        cleanlinessTextView.text = "Cleanliness: $cleanliness"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}