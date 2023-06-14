package com.example.movieshowtmdb.modules.movies_detail.repo

import com.example.movieshowtmdb.modules.movies_detail.models.MoviesDetail

interface MoviesDetailRepo {
    suspend fun getMoviesDetail(movieId: Int): MoviesDetail
}