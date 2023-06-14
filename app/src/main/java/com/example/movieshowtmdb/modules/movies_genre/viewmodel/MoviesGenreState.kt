package com.example.kotlintesttmdb.pages.movies_genre

import com.example.kotlintesttmdb.models.MoviesGenre

data class MoviesGenreState(
    val isLoading: Boolean = false,
    val data: MoviesGenre? = null,
    val error: String = ""
)