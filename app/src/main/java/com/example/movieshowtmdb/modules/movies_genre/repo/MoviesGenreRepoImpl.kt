package com.example.movieshowtmdb.modules.movies_genre.repo

import com.example.movieshowtmdb.modules.movies_genre.models.MoviesGenre
import com.example.movieshowtmdb.networking.ApiRequest
import com.example.movieshowtmdb.networking.ApiService

class MoviesGenreRepoImpl constructor(private val apiService: ApiService) : MoviesGenreRepo,
    ApiRequest() {

    override suspend fun getMoviesGenre(page: Int, withGenres: String): MoviesGenre {
        return apiRequest {
            apiService.getMoviesGenre(
                page = page,
                withGenres = withGenres,
                language = "en-US",
                sortBy = "popularity.desc"
            )
        }
    }
}