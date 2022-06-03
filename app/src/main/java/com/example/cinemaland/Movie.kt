package com.example.cinemaland
import java.io.Serializable
data class Movie(
    val name: Int,
    val description: Int,
    val image: Int,
    val like: Int,
    var selected: Boolean,
    var isFavorite: Boolean = false,

) : Serializable




