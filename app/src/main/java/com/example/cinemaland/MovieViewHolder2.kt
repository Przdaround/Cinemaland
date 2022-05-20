package com.example.cinemaland

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTv: TextView = itemView.findViewById(R.id.name)
    private val descriptionTv: TextView = itemView.findViewById(R.id.description)
    private val imageIv: ImageView = itemView.findViewById(androidx.appcompat.R.id.image)
    private val likeIv: ImageView = itemView.findViewById(R.id.like)

    fun bind(item: Movie, listener: MovieAdapter.MovieClickListener) {
        nameTv.text = itemView.context.getString(item.name)
        descriptionTv.text = itemView.context.getString(item.description)


        likeIv.setBackgroundColor(item.like)
        likeIv.setOnClickListener {
            listener.onFavoriteClick(
                item,
                adapterPosition - 1
            )
        } // -1 -> header
        imageIv.setOnClickListener {
            listener.onNewsClick(
                item,
                         // -1 -> header
                adapterPosition - 1 // -1 -> header
            )
        }
    }
}

