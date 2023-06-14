package com.example.movieshowtmdb.modules.movies_reviews.models

data class MoviesReviews(
    val id: Int,
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: List<MoviesReviewsItem>
)