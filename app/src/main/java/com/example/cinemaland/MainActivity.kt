package com.example.cinemaland



import android.content.Intent
import android.graphics.Movie
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemaland.data.Movies
import android.content.Context as ContentContext
import com.example.cinemaland.Movie as Movie1


class MainActivity : AppCompatActivity() {
    private val adapter = MovieAdapter()

   private val recyclerView by lazy { findViewById<RecyclerView>(R.id.recycler) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initRecycler()

    }

    private fun initRecycler() {

        val movieAdapter = adapter
        recyclerView.adapter = adapter
adapter.movielist = Movies.movielist
        adapter.listener = object: MovieAdapter.MovieClickListener{


             override fun onClick(Item: com.example.cinemaland.Movie, position: Int) {
                 val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                 intent.putExtra("MOVIE_KEY", Item )
                    startActivity(intent)



            }





            override fun onFavoriteClick(Item: com.example.cinemaland.Movie, position: Int) {

                adapter.notifyItemChanged(position)
            }
        }


        adapter.notifyDataSetChanged()
    }




    override fun onBackPressed() {
        super.onBackPressed()
        AlertDialog.Builder(this).apply {
            setTitle("Please confirm")
            setMessage("Do you want to exit?")

            setPositiveButton("Yes") { _, _ ->
                super.onBackPressed()
            }

            setNegativeButton("No"){_, _ ->
                // if user press no, then return the activity
                Toast.makeText(this@MainActivity, "Thank you",
                    Toast.LENGTH_SHORT
                ).show()
            }
            setCancelable(true)
        }.create().show()
}
}



//private fun Intent.putExtra(name: String, movie: Movie) {


















