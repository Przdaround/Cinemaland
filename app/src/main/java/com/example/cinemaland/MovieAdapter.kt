package com.example.cinemaland

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView




class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder2>() {
    var movielist: List<Movie> = ArrayList<Movie>()
    lateinit var listener: MovieClickListener




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder2 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_news, parent, false)
        return MovieViewHolder2(view)
        }




    override fun onBindViewHolder(holder: MovieViewHolder2, position: Int) {
        holder.bind(movielist[position], listener, 0)
    }

    override fun getItemCount(): Int {
        return movielist.size
    }



    override fun getItemViewType(position: Int): Int {
        return 0

    }

    class MovieViewHolder2(val item: View): RecyclerView.ViewHolder(item) {
        private lateinit var image: ImageView
        private lateinit var name: TextView
        private lateinit var favorite: ImageView
        private lateinit var button: Button


        fun bind(movie: Movie, listener: MovieClickListener?, position: Int) {
            image = item.findViewById(R.id.image)
            name = item.findViewById(R.id.name)
            favorite = item.findViewById(R.id.favorite)
            button = item.findViewById(R.id.btn)

            image.setImageResource(movie.image)
            name.setText(movie.name)
            favorite.setImageResource(
                if (movie.isFavorite){
                    R.drawable.ic_baseline_favorite_24
                } else {
                    R.drawable.ic_baseline_favorite_border_24
                }
            )
            favorite.setOnClickListener{
                listener!!.onFavoriteClick(movie, 0)
            }
            button.setOnClickListener{
                listener!!.onClick(movie, 0)




            }
        }


    }

    interface MovieClickListener {
        fun onClick(newsItem: Movie, position: Int)
        fun onFavoriteClick(newsItem: Movie, position: Int)

    }
}
