package com.example.movieshowtmdb.modules.movies_detail.models

import com.example.movieshowtmdb.modules.home.models.GenresItem

data class MoviesDetail(
    val backdrop_path: String,
    val budget: Int,
    val id: Int,
    val title: String,
    val release_date: String,
    val tagline: String,
    val overview: String,
    val vote_average: Number,
    val vote_count: Int,
    val genres: List<GenresItem>
)