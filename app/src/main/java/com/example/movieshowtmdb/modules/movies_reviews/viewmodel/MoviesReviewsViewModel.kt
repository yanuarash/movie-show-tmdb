package com.example.kotlintesttmdb.pages.movies_reviews

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintesttmdb.network.Resource
import com.example.movieshowtmdb.modules.movies_reviews.usecase.MoviesReviewsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MoviesReviewsViewModel constructor(private val moviesReviewsUseCase: MoviesReviewsUseCase) :
    ViewModel() {
    private val _state = mutableStateOf(MoviesReviewsState())
    val state: State<MoviesReviewsState> = _state

    fun getMoviesReviews(movieId: Int, page: Int) {
        val res = moviesReviewsUseCase.invoke(movieId, page)
        res.onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = MoviesReviewsState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = MoviesReviewsState(data = result.data)
                }

                is Resource.Error -> {
                    _state.value =
                        MoviesReviewsState(error = result.message ?: "error getting data")
                }
            }
        }.launchIn(viewModelScope)
    }
}