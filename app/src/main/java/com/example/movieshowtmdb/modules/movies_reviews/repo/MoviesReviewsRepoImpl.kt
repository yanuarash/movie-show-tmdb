package com.example.movieshowtmdb.modules.movies_reviews.repo

import com.example.movieshowtmdb.modules.movies_reviews.models.MoviesReviews
import com.example.movieshowtmdb.networking.ApiRequest
import com.example.movieshowtmdb.networking.ApiService

class MoviesReviewsRepoImpl constructor(private val apiService: ApiService) : MoviesReviewsRepo,
    ApiRequest() {

    override suspend fun getMoviesReviews(movieId: Int, page: Int): MoviesReviews {
        return apiRequest { apiService.getMoviesReviews(movieId, page) }
    }
}