package com.example.movieshowtmdb.modules.home.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintesttmdb.network.Resource
import com.example.movieshowtmdb.modules.home.usecase.GenresUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeViewModel constructor(private val genresUseCase: GenresUseCase) : ViewModel() {
    private val _state = mutableStateOf(GenresState())
    val state: State<GenresState> = _state

    init {
        getGenres()
    }

    private fun getGenres(){
        val res = genresUseCase.invoke("en-US")
        res.onEach { result ->
            when(result){
                is Resource.Loading -> {
                    _state.value = GenresState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = GenresState(data = result.data)
                }

                is Resource.Error -> {
                    _state.value = GenresState(error = result.message ?: "error getting data")
                }
            }
        }.launchIn(viewModelScope)
    }
}