package com.example.kotlintesttmdb.pages.movies_reviews

import com.example.kotlintesttmdb.models.MoviesReviews

data class MoviesReviewsState(
    val isLoading: Boolean = false,
    val data: MoviesReviews? = null,
    val error: String = ""
)