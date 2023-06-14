package com.example.kotlintesttmdb.network.repo

import com.example.kotlintesttmdb.models.MoviesDetail

interface MoviesDetailRepo{
    suspend fun getMoviesDetail(movieId: Int): MoviesDetail
}