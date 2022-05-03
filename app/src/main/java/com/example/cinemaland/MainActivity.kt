package com.example.cinemaland

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGreenMile = findViewById<Button>(R.id.btn_green_mile)
        btnGreenMile.setOnClickListener {
            // TODO запустить активити с деталями
            val intent = Intent(this, DetailsActivity::class.java)
            val movie = Movie(
                "Зеленая Миля",
                "Грустный фильм про тюрьму"
            )
            intent.putExtra("movie", movie)
            startActivity(intent)
        }
    }

}




