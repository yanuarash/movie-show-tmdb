package com.example.movieshowtmdb.modules.movies_videos.repo

import com.example.movieshowtmdb.modules.movies_videos.models.MoviesVideos
import com.example.movieshowtmdb.networking.ApiRequest
import com.example.movieshowtmdb.networking.ApiService

class MoviesVideosRepoImpl constructor(private val apiService: ApiService) : MoviesVideosRepo,
    ApiRequest() {
    override suspend fun getMoviesVideos(movieId: Int): MoviesVideos {
        return apiRequest { apiService.getMoviesVideos(movieId) }
    }
}