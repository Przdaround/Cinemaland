package com.example.cinemaland

import java.io.Serializable

data class Movie(
    val name: Int,
    val id: Int,
    val description: Int,
    var selected: Boolean,
) : Serializable

