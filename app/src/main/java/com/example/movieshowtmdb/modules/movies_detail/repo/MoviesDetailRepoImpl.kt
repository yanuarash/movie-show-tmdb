package com.example.movieshowtmdb.modules.movies_detail.repo

import com.example.movieshowtmdb.modules.movies_detail.models.MoviesDetail
import com.example.movieshowtmdb.networking.ApiRequest
import com.example.movieshowtmdb.networking.ApiService

class MoviesDetailRepoImpl constructor(private val apiService: ApiService) : MoviesDetailRepo,
    ApiRequest() {

    override suspend fun getMoviesDetail(movieId: Int): MoviesDetail {
        return apiRequest { apiService.getMoviesDetail(movieId) }
    }
}