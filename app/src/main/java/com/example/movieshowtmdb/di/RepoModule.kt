package com.example.kotlintesttmdb.di

import com.example.kotlintesttmdb.network.repo.MoviesDetailRepo
import com.example.kotlintesttmdb.network.repo.MoviesDetailRepoImpl
import com.example.kotlintesttmdb.network.repo.MoviesGenreRepo
import com.example.kotlintesttmdb.network.repo.MoviesGenreRepoImpl
import com.example.kotlintesttmdb.network.repo.MoviesReviewsRepo
import com.example.kotlintesttmdb.network.repo.MoviesReviewsRepoImpl
import com.example.movieshowtmdb.modules.home.repo.GenreRepoImpl
import com.example.movieshowtmdb.modules.home.repo.GenresRepo
import com.example.movieshowtmdb.modules.home.usecase.GenresUseCase
import com.example.movieshowtmdb.modules.movies_detail.usecase.MoviesDetailUseCase
import com.example.movieshowtmdb.modules.movies_genre.usecase.MoviesGenreUseCase
import com.example.movieshowtmdb.modules.movies_reviews.usecase.MoviesReviewsUseCase
import org.koin.dsl.module

val repoModule = module {
    single { GenresUseCase(get()) }
    single<GenresRepo> { GenreRepoImpl(get()) }
    single { MoviesGenreUseCase(get()) }
    single<MoviesGenreRepo> { MoviesGenreRepoImpl(get()) }
    single { MoviesDetailUseCase(get()) }
    single<MoviesDetailRepo> { MoviesDetailRepoImpl(get()) }
    single { MoviesReviewsUseCase(get()) }
    single<MoviesReviewsRepo> { MoviesReviewsRepoImpl(get()) }
}