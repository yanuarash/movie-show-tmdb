package com.example.kotlintesttmdb.network

import com.example.kotlintesttmdb.models.*
import com.example.movieshowtmdb.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String,
    ): Response<Genres>

    @GET("discover/movie")
    suspend fun getMoviesGenre(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String,
        @Query("sort_by") sortBy: String,
        @Query("page") page: Int,
        @Query("with_genres") withGenres: String,
    ): Response<MoviesGenre>
}