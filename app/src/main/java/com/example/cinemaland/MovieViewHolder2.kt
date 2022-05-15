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

    fun bind(item: Movie, listener: NewsItemAdapter.NewsClickListener) {
        nameTv.text = item.name
        descriptionTv.text = item.description
        if (item.image == Color.BLUE) {
            nameTv.setTextColor(Color.GREEN)
        } else {
            nameTv.setTextColor(Color.GRAY)
        }
        imageIv.setBackgroundColor(item.image)
        imageIv.setOnClickListener {
            listener.onFavoriteClick(
                item,
                adapterPosition - 1
            )
        } // -1 -> header
        itemView.setOnClickListener {
            listener.onNewsClick(
                item, // -1 -> header
                adapterPosition - 1 // -1 -> header
            )
        }
    }
}
