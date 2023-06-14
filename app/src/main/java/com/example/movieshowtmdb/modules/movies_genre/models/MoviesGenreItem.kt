package com.example.kotlintesttmdb.models

data class MoviesGenreItem(
    val backdrop_path: String,
    val poster_path: String,
    val adult: Boolean,
    val overview: String,
    val release_date: String,
    val id: Int,
    val original_title: String,
    val original_language: String,
    val title: String,
    val popularity: Number,
    val vote_count: Int,
    val vote_average: Number,
)