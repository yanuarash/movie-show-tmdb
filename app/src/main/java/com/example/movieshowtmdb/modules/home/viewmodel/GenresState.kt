package com.example.movieshowtmdb.modules.home.viewmodel

import com.example.movieshowtmdb.modules.home.models.Genres

data class GenresState(
    val isLoading: Boolean = false,
    val data: Genres? = null,
    val error: String = ""
)