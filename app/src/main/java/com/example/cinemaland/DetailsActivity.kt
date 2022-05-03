package com.example.cinemaland

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val movie = intent.getSerializableExtra("movie") as Movie

        val nameView = findViewById<TextView>(R.id.name)
        nameView.text = movie.name

        val descriptionView = findViewById<TextView>(R.id.description)
        descriptionView.text = movie.description
    }
}