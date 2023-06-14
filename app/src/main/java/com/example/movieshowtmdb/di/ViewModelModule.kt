package com.example.kotlintesttmdb.di

import com.example.movieshowtmdb.modules.home.viewmodel.HomeViewModel
import com.example.movieshowtmdb.modules.movies_detail.viewmodel.MoviesDetailViewModel
import com.example.movieshowtmdb.modules.movies_genre.viewmodel.MoviesGenreViewModel
import com.example.movieshowtmdb.modules.movies_reviews.viewmodel.MoviesReviewsViewModel
import com.example.movieshowtmdb.modules.movies_videos.viewmodel.MoviesVideosViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { MoviesGenreViewModel(get()) }
    viewModel { MoviesDetailViewModel(get()) }
    viewModel { MoviesReviewsViewModel(get()) }
    viewModel { MoviesVideosViewModel(get()) }
}