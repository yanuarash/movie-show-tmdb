package com.example.movieshowtmdb.modules.movies_videos.viewmodel

import com.example.movieshowtmdb.modules.movies_videos.models.MoviesVideos

data class MoviesVideosState(
    val isLoading: Boolean = false,
    val data: MoviesVideos? = null,
    val error: String = ""
)