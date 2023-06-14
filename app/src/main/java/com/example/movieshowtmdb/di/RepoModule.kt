package com.example.kotlintesttmdb.di

import com.example.kotlintesttmdb.network.repo.MoviesGenreRepo
import com.example.kotlintesttmdb.network.repo.MoviesGenreRepoImpl
import com.example.movieshowtmdb.modules.home.repo.GenreRepoImpl
import com.example.movieshowtmdb.modules.home.repo.GenresRepo
import com.example.movieshowtmdb.modules.home.usecase.GenresUseCase
import com.example.movieshowtmdb.modules.movies_genre.usecase.MoviesGenreUseCase
import org.koin.dsl.module

val repoModule = module {
    single { GenresUseCase(get()) }
    single<GenresRepo> { GenreRepoImpl(get()) }
    single { MoviesGenreUseCase(get()) }
    single<MoviesGenreRepo> { MoviesGenreRepoImpl(get()) }
}