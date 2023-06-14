package com.example.movieshowtmdb.modules.movies_genre.models

data class MoviesGenre(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: List<MoviesGenreItem>
)