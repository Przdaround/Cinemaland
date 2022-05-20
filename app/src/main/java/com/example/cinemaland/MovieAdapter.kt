package com.example.cinemaland

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder2>() {
   private val movielist = ArrayList<Movie>()
    class MovieViewHolder2(item: View): RecyclerView.ViewHolder(item) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder2 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_news, parent, false)
        return MovieViewHolder2(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder2, position: Int) {
        holder.bind(movielist[position])
    }

    override fun getItemCount(): Int {
        return movielist.size
    }

    fun addPlant(movie: Movie){
        movielist.add(movie)
        notifyDataSetChanged()
    }
}