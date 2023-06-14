package com.example.kotlintesttmdb.network.repo

import com.example.kotlintesttmdb.network.ApiRequest
import com.example.kotlintesttmdb.network.ApiService
import com.example.movieshowtmdb.modules.movies_detail.models.MoviesDetail

class MoviesDetailRepoImpl constructor(private val apiService: ApiService): MoviesDetailRepo, ApiRequest(){

    override suspend fun getMoviesDetail(movieId: Int): MoviesDetail {
        return apiRequest { apiService.getMoviesDetail(movieId) }
    }
}