package com.example.movieshowtmdb.modules.movies_videos.repo

import com.example.movieshowtmdb.modules.movies_videos.models.MoviesVideos

interface MoviesVideosRepo {
    suspend fun getMoviesVideos(movieId: Int): MoviesVideos
}