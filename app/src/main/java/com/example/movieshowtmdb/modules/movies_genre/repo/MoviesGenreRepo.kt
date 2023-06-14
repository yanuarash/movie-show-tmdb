package com.example.movieshowtmdb.modules.movies_genre.repo

import com.example.movieshowtmdb.modules.movies_genre.models.MoviesGenre

interface MoviesGenreRepo {
    suspend fun getMoviesGenre(page: Int, withGenres: String): MoviesGenre
}