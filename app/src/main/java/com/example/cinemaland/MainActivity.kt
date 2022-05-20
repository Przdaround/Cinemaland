package com.example.cinemaland



import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

   private val recyclerView by lazy { findViewById<RecyclerView>(R.id.recycler) }
   object Movies {
     val movielist = mutableListOf(
        Movie(R.string.the_green_mile, R.string.dsc_the_green_mile, R.drawable.green_mile, R.drawable.heart,false),
        Movie(R.string.breaking_bad, R.string.dsc_breaking_bad, R.drawable.breaking_bad, R.drawable.heart,false),
        Movie(R.string.shutter_island, R.string.dsc_shutter_island, R.drawable.shutter_island, R.drawable.heart,false),
        Movie(R.string.days_later, R.string.dsc_days_later, R.drawable.days_later, R.drawable.heart,false),
        Movie(R.string.inception, R.string.dsc_inception, R.drawable.inception, R.drawable.heart,false),
        Movie(R.string.mad_max, R.string.dsc_mad_max, R.drawable.mad_max, R.drawable.heart,false),
        Movie(R.string.memento, R.string.dsc_memento, R.drawable.memento, R.drawable.heart,false),
        Movie(R.string.the_imitation_game, R.string.dsc_the_imitation_game, R.drawable.the_imitation_game, R.drawable.heart,false)


    )

       // NewsItem("Title 2", "Subtitle 2", Color.YELLOW),

   }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        val btnGreenMile = findViewById<Button>(R.id.btn)
        val textGreenMile = findViewById<TextView>(R.id.name)
        if (Movies.movielist[0].selected) {
            textGreenMile.setTextColor(ContextCompat.getColor(this, R.color.teal_200))
        }
        btnGreenMile.setOnClickListener {
            textGreenMile.setTextColor(ContextCompat.getColor(this, R.color.teal_200))
            Movies.movielist[0].selected = true

            val intent = Intent(this, DetailsActivity::class.java)

            intent.putExtra("MOVIE_KEY", Movies.movielist[0])
            startActivity(intent)
        }

        initRecycler()
        initClickListeners()
    }

    private fun initClickListeners() {
        findViewById<View>(R.id.like).setOnClickListener {
            recyclerView.adapter?.notifyItemInserted(2 + 1)// +1 -> header
        }
        findViewById<View>(R.id.btn).setOnClickListener {
            recyclerView.adapter?.notifyItemRemoved(2 + 1)// +1 -> header
        }
    }

    private fun initRecycler() {
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = MovieAdapter( Movie, object : MovieAdapter.MovieClickListener {

        })



            }



        }



//private fun Intent.putExtra(name: String, movie: Movie) {


















