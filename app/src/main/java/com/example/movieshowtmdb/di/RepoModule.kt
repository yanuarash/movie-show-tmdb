package com.example.kotlintesttmdb.di

import com.example.movieshowtmdb.modules.home.repo.GenreRepoImpl
import com.example.movieshowtmdb.modules.home.repo.GenresRepo
import com.example.movieshowtmdb.modules.home.usecase.GenresUseCase
import org.koin.dsl.module

val repoModule = module {
    single { GenresUseCase(get()) }
    single<GenresRepo> { GenreRepoImpl(get()) }
}