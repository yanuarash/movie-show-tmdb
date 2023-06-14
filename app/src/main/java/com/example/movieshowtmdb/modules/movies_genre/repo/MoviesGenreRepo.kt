package com.example.kotlintesttmdb.network.repo

import com.example.kotlintesttmdb.models.MoviesGenre

interface MoviesGenreRepo{
    suspend fun getMoviesGenre(page: Int, withGenres: String): MoviesGenre
}