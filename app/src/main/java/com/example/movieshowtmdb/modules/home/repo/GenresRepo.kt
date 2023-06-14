package com.example.movieshowtmdb.modules.home.repo

import com.example.kotlintesttmdb.models.Genres

interface GenresRepo{
    suspend fun getGenres(language:String):Genres
}