package com.example.movieshowtmdb.modules.movies_videos.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieshowtmdb.modules.movies_videos.usecase.MoviesVideosUseCase
import com.example.movieshowtmdb.networking.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MoviesVideosViewModel constructor(private val moviesVideosUseCase: MoviesVideosUseCase) :
    ViewModel() {
    private val _state = mutableStateOf(MoviesVideosState())
    val state: State<MoviesVideosState> = _state

    fun getMoviesVideos(movieId: Int) {
        val res = moviesVideosUseCase.invoke(movieId)
        res.onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = MoviesVideosState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = MoviesVideosState(data = result.data)
                }

                is Resource.Error -> {
                    _state.value = MoviesVideosState(error = result.message ?: "error getting data")
                }
            }
        }.launchIn(viewModelScope)
    }
}