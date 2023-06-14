package com.example.kotlintesttmdb.di

import com.example.movieshowtmdb.modules.home.repo.GenreRepoImpl
import com.example.movieshowtmdb.modules.home.repo.GenresRepo
import com.example.movieshowtmdb.modules.home.usecase.GenresUseCase
import com.example.movieshowtmdb.modules.movies_detail.repo.MoviesDetailRepo
import com.example.movieshowtmdb.modules.movies_detail.repo.MoviesDetailRepoImpl
import com.example.movieshowtmdb.modules.movies_detail.usecase.MoviesDetailUseCase
import com.example.movieshowtmdb.modules.movies_genre.repo.MoviesGenreRepo
import com.example.movieshowtmdb.modules.movies_genre.repo.MoviesGenreRepoImpl
import com.example.movieshowtmdb.modules.movies_genre.usecase.MoviesGenreUseCase
import com.example.movieshowtmdb.modules.movies_reviews.repo.MoviesReviewsRepo
import com.example.movieshowtmdb.modules.movies_reviews.repo.MoviesReviewsRepoImpl
import com.example.movieshowtmdb.modules.movies_reviews.usecase.MoviesReviewsUseCase
import com.example.movieshowtmdb.modules.movies_videos.repo.MoviesVideosRepo
import com.example.movieshowtmdb.modules.movies_videos.repo.MoviesVideosRepoImpl
import com.example.movieshowtmdb.modules.movies_videos.usecase.MoviesVideosUseCase
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
    single { MoviesVideosUseCase(get()) }
    single<MoviesVideosRepo> { MoviesVideosRepoImpl(get()) }
}