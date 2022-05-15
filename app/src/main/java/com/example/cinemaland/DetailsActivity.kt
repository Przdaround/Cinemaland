package com.example.cinemaland

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val movie = intent.getSerializableExtra("movie") as Movie

        val nameView = findViewById<TextView>(R.id.name)
        nameView.text = getString(movie.name)

        val descriptionView = findViewById<TextView>(R.id.description)
        descriptionView.text = getString(movie.description)

        val imageView = findViewById<ImageView>(androidx.appcompat.R.id.image)
        descriptionView.text = getString(movie.image)

        val btnShare = findViewById<Button>(R.id.btn_share)
        btnShare.setOnClickListener {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,"Take a look to this movie!")
            putExtra(Intent.EXTRA_EMAIL, "Email")
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
    }}
}