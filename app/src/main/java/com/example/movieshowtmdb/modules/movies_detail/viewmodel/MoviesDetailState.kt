package com.example.movieshowtmdb.modules.movies_detail.viewmodel

import com.example.movieshowtmdb.modules.movies_detail.models.MoviesDetail

data class MoviesDetailState(
    val isLoading: Boolean = false,
    val data: MoviesDetail? = null,
    val error: String = ""
)