package com.example.kotlintesttmdb.pages.movies_genre

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintesttmdb.models.MoviesGenreItem
import com.example.kotlintesttmdb.network.Resource
import com.example.movieshowtmdb.modules.movies_genre.usecase.MoviesGenreUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MoviesGenreViewModel constructor(private val moviesGenreUseCase: MoviesGenreUseCase) :
    ViewModel() {
    private val _state = mutableStateOf(MoviesGenreState())
    var list = mutableStateListOf<MoviesGenreItem>()
    val state: State<MoviesGenreState> = _state

    fun getMoviesGenre(page: Int, withGenres: String) {
        val res = moviesGenreUseCase.invoke(page = page, withGenres = withGenres)
        res.onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = MoviesGenreState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = MoviesGenreState(isLoading = false, data = result.data)
                    result.data?.let {
                        list.addAll(it.results)
                    }
                }

                is Resource.Error -> {
                    _state.value = MoviesGenreState(
                        isLoading = false,
                        error = result.message ?: "error getting data"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}