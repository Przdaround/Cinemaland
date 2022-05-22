package com.example.cinemaland

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
private const val TAG = "NewsItemAdapter"
private const val HEADER_VIEW_TYPE = 0
private const val ITEM_VIEW_TYPE = 1

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder2>() {
   private val movielist = ArrayList<Movie>()
    private val listener = MovieClickListener
    class MovieViewHolder2(item: View): RecyclerView.ViewHolder(item) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder2 {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            HEADER_VIEW_TYPE -> HeaderMovieViewHolder(
                inflater.inflate(R.layout.headermovie, parent, false)
            )
            else -> MovieViewHolder2(inflater.inflate(R.layout.movie_news))
        }
    }



    override fun onBindViewHolder(holder: MovieViewHolder2, position: Int) {
        holder.bind(movielist[position])
    }

    override fun getItemCount(): Int {
        return movielist.size + 1
    }

    fun addMovie(movie: Movie){
        movielist.add(movie)
        notifyDataSetChanged()
    }
    override fun getItemViewType(position: Int): Int {
        return if (position == 0) HEADER_VIEW_TYPE else ITEM_VIEW_TYPE
    }
    interface MovieClickListener {
        fun onNewsClick(newsItem: Movie, position: Int)
        fun onFavoriteClick(newsItem: Movie, position: Int)
    }
}