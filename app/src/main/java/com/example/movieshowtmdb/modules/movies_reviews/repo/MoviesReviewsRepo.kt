package com.example.movieshowtmdb.modules.movies_reviews.repo

import com.example.movieshowtmdb.modules.movies_reviews.models.MoviesReviews

interface MoviesReviewsRepo {
    suspend fun getMoviesReviews(movieId: Int, page: Int): MoviesReviews
}