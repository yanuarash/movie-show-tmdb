package com.example.movieshowtmdb.modules.movies_detail.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieshowtmdb.modules.movies_detail.usecase.MoviesDetailUseCase
import com.example.movieshowtmdb.networking.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MoviesDetailViewModel constructor(private val moviesDetailUseCase: MoviesDetailUseCase) :
    ViewModel() {
    private val _state = mutableStateOf(MoviesDetailState())
    val state: State<MoviesDetailState> = _state

    fun getMoviesDetail(movieId: Int) {
        val res = moviesDetailUseCase.invoke(movieId)
        res.onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = MoviesDetailState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = MoviesDetailState(data = result.data)
                }

                is Resource.Error -> {
                    _state.value = MoviesDetailState(error = result.message ?: "error getting data")
                }
            }
        }.launchIn(viewModelScope)
    }
}