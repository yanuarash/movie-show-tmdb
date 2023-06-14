package com.example.kotlintesttmdb.pages.movies_videos

import com.example.kotlintesttmdb.models.MoviesVideos

data class MoviesVideosState(
    val isLoading: Boolean = false,
    val data: MoviesVideos? = null,
    val error: String = ""
)