package com.example.kotlintesttmdb.di

import com.example.kotlintesttmdb.pages.movies_detail.MoviesDetailViewModel
import com.example.kotlintesttmdb.pages.movies_genre.MoviesGenreViewModel
import com.example.movieshowtmdb.modules.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { MoviesGenreViewModel(get()) }
    viewModel { MoviesDetailViewModel(get()) }
}