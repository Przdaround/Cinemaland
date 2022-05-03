package com.example.cinemaland

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGreenMile = findViewById<Button>(R.id.btn_green_mile)
        val textGreenMile = findViewById<TextView>(R.id.textView_green_mile)
        if (Movies.movielist[0].selected){
            textGreenMile.setTextColor(ContextCompat.getColor(this,R.color.teal_200))
        }
        btnGreenMile.setOnClickListener {
            textGreenMile.setTextColor(ContextCompat.getColor(this,R.color.teal_200))
            Movies.movielist[0].selected = true
            // TODO запустить активити с деталями
            val intent = Intent(this, DetailsActivity::class.java)

            intent.putExtra("movie", Movies.movielist[0])
            startActivity(intent)
        }
    }

}
object Movies {
    val movielist = listOf<Movie>(Movie(
            R.string.the_green_mile,1,
    R.string.dsc_the_green_mile, false
    ))
}


