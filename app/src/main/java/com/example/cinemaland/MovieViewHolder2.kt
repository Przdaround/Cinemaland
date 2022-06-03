package com.example.cinemaland

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.CheckableImageButton

class MovieViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTv: TextView = itemView.findViewById(R.id.name)
    private val descriptionTv: TextView = itemView.findViewById(R.id.description)
    private val imageIv: ImageView = itemView.findViewById(androidx.appcompat.R.id.image)
    private val favoriteIv: CheckableImageButton = itemView.findViewById(R.id.favorite)
    private val button: Button = itemView.findViewById(R.id.btn)

    fun bind(item: Movie, listener: MovieAdapter.MovieClickListener) {
        nameTv.text = itemView.context.getString(item.name)
        descriptionTv.text = itemView.context.getString(item.description)


        favoriteIv.setOnClickListener {
            listener.onFavoriteClick(item, 0)

        }

        button.setOnClickListener {
            listener.onClick(item, 0) }

    fun checkSelected(movie: Movie){
        if (!movie.selected) {
            nameTv.setTextColor(Color.CYAN)
        }else{
            nameTv.setTextColor(Color.GREEN)
        }
    }

    }


}

