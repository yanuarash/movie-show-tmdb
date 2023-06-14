package com.example.movieshowtmdb.networking

import com.example.kotlintesttmdb.models.*
import com.example.movieshowtmdb.modules.home.models.Genres
import com.example.movieshowtmdb.modules.movies_detail.models.MoviesDetail
import com.example.movieshowtmdb.modules.movies_genre.models.MoviesGenre
import com.example.movieshowtmdb.modules.movies_reviews.models.MoviesReviews
import com.example.movieshowtmdb.modules.movies_videos.models.MoviesVideos
import com.example.movieshowtmdb.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
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

    @GET("movie/{movie_id}")
    suspend fun getMoviesDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY,
    ): Response<MoviesDetail>

    @GET("movie/{movie_id}/videos")
    suspend fun getMoviesVideos(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY,
    ): Response<MoviesVideos>

    @GET("movie/{movie_id}/reviews")
    suspend fun getMoviesReviews(
        @Path("movie_id") movieId: Int,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY,
    ): Response<MoviesReviews>
}