package com.example.kotlintesttmdb.network.repo

import com.example.kotlintesttmdb.models.MoviesVideos
import com.example.kotlintesttmdb.network.ApiRequest
import com.example.kotlintesttmdb.network.ApiService

class MoviesVideosRepoImpl constructor(private val apiService: ApiService) : MoviesVideosRepo,
    ApiRequest() {
    override suspend fun getMoviesVideos(movieId: Int): MoviesVideos {
        return apiRequest { apiService.getMoviesVideos(movieId) }
    }
}