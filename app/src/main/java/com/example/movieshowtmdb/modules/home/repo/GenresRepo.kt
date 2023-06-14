package com.example.movieshowtmdb.modules.home.repo

import com.example.movieshowtmdb.modules.home.models.Genres

interface GenresRepo {
    suspend fun getGenres(language: String): Genres
}