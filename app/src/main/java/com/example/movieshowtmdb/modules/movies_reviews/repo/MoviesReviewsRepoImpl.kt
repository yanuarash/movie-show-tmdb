package com.example.kotlintesttmdb.network.repo

import com.example.kotlintesttmdb.models.MoviesReviews
import com.example.kotlintesttmdb.network.ApiRequest
import com.example.kotlintesttmdb.network.ApiService

class MoviesReviewsRepoImpl constructor(private val apiService: ApiService): MoviesReviewsRepo, ApiRequest(){

    override suspend fun getMoviesReviews(movieId: Int, page: Int): MoviesReviews {
        return apiRequest { apiService.getMoviesReviews(movieId, page) }
    }
}