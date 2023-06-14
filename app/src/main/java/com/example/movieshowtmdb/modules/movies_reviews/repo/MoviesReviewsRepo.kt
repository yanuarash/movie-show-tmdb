package com.example.kotlintesttmdb.network.repo

import com.example.kotlintesttmdb.models.MoviesReviews

interface MoviesReviewsRepo{
    suspend fun getMoviesReviews(movieId: Int, page: Int): MoviesReviews
}