package com.example.cinemaland

import java.io.Serializable

data class Movie(
    val name: String,
    val description: String,
) : Serializable

