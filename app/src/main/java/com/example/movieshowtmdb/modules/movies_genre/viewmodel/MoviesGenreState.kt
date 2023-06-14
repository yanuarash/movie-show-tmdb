package com.example.movieshowtmdb.modules.movies_genre.viewmodel

import com.example.movieshowtmdb.modules.movies_genre.models.MoviesGenre

data class MoviesGenreState(
    val isLoading: Boolean = false,
    val data: MoviesGenre? = null,
    val error: String = ""
)