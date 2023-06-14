package com.example.kotlintesttmdb.models

data class MoviesGenre(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: List<MoviesGenreItem>
)