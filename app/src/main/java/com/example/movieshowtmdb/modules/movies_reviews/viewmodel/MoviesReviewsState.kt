package com.example.movieshowtmdb.modules.movies_reviews.viewmodel

import com.example.movieshowtmdb.modules.movies_reviews.models.MoviesReviews

data class MoviesReviewsState(
    val isLoading: Boolean = false,
    val data: MoviesReviews? = null,
    val error: String = ""
)