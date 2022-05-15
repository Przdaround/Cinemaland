package com.example.cinemaland

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "MovieAdapter"
private const val HEADER_VIEW_TYPE = 0
private const val ITEM_VIEW_TYPE = 1

class MovieAdapter(
    private val movie: List<Movie>,
    private val listener: NewsClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d(TAG, "onCreateViewHolder: $viewType")

        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            HEADER_VIEW_TYPE -> HeaderItemViewHolder(
                inflater.inflate(R.layout.item_header_news, parent, false)
            )
            else -> MovieViewHolder(inflater.inflate(R.layout.item_news, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: $position")

        when (holder) {
            is MovieViewHolder -> {
                holder.bind(items[position - 1], listener) // -1 -> header
            }
        }
    }

    override fun getItemCount(): Int = items.size + 1 // +1 -> header

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) HEADER_VIEW_TYPE else ITEM_VIEW_TYPE
    }

    interface NewsClickListener {
        fun onNewsClick(newsItem: NewsItem, position: Int)
        fun onFavoriteClick(newsItem: NewsItem, position: Int)
    }
}