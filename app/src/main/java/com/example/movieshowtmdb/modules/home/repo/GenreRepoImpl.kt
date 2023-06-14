package com.example.movieshowtmdb.modules.home.repo

import com.example.movieshowtmdb.modules.home.models.Genres
import com.example.movieshowtmdb.networking.ApiRequest
import com.example.movieshowtmdb.networking.ApiService

class GenreRepoImpl constructor(private val apiService: ApiService) : GenresRepo, ApiRequest() {

    override suspend fun getGenres(language: String): Genres {
        return apiRequest { apiService.getGenres(language = "en-US") }
    }
}