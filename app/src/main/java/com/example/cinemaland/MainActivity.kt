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
import com.example.cinemaland.MainActivity.Movies.movielist


class MainActivity : AppCompatActivity() {
    private val adapter = MovieAdapter()

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

    }




    private fun initRecycler() {
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = MovieAdapter(movielist, object : MovieAdapter.MovieClickListener {
            override fun onNewsClick(movie: Movie , position: Int) {
                Toast.makeText(this@MainActivity, "News Click", Toast.LENGTH_SHORT).show()
            }

            override fun onFavoriteClick(Movie: Movie, position: Int) {
                Toast.makeText(this@MainActivity, "Favorite Click", Toast.LENGTH_SHORT).show()
            }
        })

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (layoutManager.findLastVisibleItemPosition() >= movielist.size - 5) {
                    repeat(10) {
                        movielist.add(Movie(R.string.the_green_mile, R.string.dsc_the_green_mile, R.drawable.green_mile, R.drawable.heart,false))
                    }
                    recyclerView.adapter?.notifyItemRangeInserted(
                        movielist.size + 1,
                        10)





            }
    }



        })
    }
}



//private fun Intent.putExtra(name: String, movie: Movie) {


















