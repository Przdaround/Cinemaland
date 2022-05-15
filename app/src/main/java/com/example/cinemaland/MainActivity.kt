package com.example.cinemaland



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

   // private val recyclerView by lazy { findViewById<RecyclerView>(R.id.recycler) }
   object Movies {
    val movielist = mutableListOf(
        Movie(R.string.the_green_mile, R.string.dsc_the_green_mile, R.drawable.green_mile, false),
        Movie(R.string.breaking_bad, R.string.dsc_breaking_bad, R.drawable.breaking_bad, false),
        Movie(R.string.shutter_island, R.string.dsc_shutter_island, R.drawable.shutter_island, false)
    )

       // NewsItem("Title 2", "Subtitle 2", Color.YELLOW),
       // NewsItem("Title 3", "Subtitle 3", Color.GRAY),
       // NewsItem("Title 1", "Subtitle 1", Color.BLUE),
        //NewsItem("Title 2", "Subtitle 2", Color.YELLOW),
       // NewsItem("Title 3", "Subtitle 3", Color.GRAY)

   }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val btnGreenMile = findViewById<Button>(R.id.btn_green_mile)
        val textGreenMile = findViewById<TextView>(R.id.textView_green_mile)
        if (Movies.movielist[0].selected) {
            textGreenMile.setTextColor(ContextCompat.getColor(this, R.color.teal_200))
        }
        btnGreenMile.setOnClickListener {
            textGreenMile.setTextColor(ContextCompat.getColor(this, R.color.teal_200))
            Movies.movielist[0].selected = true

            val intent = Intent(this, DetailsActivity::class.java)

            intent.putExtra(R.string.the_green_mile, Movies.movielist[0])
            startActivity(intent)
        }


        val btnBreakingBad = findViewById<Button>(R.id.btn_breaking_bad)
        val textBreakingBad = findViewById<TextView>(R.id.textView_breaking_bad)
        if (Movies.movielist[0].selected) {
            textBreakingBad.setTextColor(ContextCompat.getColor(this, R.color.teal_200))
        }
        btnBreakingBad.setOnClickListener {
            textBreakingBad.setTextColor(ContextCompat.getColor(this, R.color.teal_200))
            Movies.movielist[0].selected = true

            val intent = Intent(this, DetailsActivity::class.java)

            intent.putExtra(R.string.breaking_bad, Movies.movielist[0])
            startActivity(intent)
        }

        val btnshutterisland = findViewById<Button>(R.id.btn_shutter_island)
        val textShutterisland = findViewById<TextView>(R.id.textView_shutter_island)
        if (Movies.movielist[0].selected) {
            textShutterisland.setTextColor(ContextCompat.getColor(this, R.color.teal_200))
        }
        btnshutterisland.setOnClickListener {
            textShutterisland.setTextColor(ContextCompat.getColor(this, R.color.teal_200))
            Movies.movielist[0].selected = true

            val intent = Intent(this, DetailsActivity::class.java)

            intent.putExtra(R.string.shutter_island, Movies.movielist[0])
            startActivity(intent)
        }
            }



        }

//private fun Intent.putExtra(name: String, movie: Movie) {


















