package com.example.movieshowtmdb.modules.home.usecase

import com.example.kotlintesttmdb.models.Genres
import com.example.kotlintesttmdb.network.Resource
import com.example.movieshowtmdb.modules.home.repo.GenresRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GenresUseCase constructor(private val genresRepo: GenresRepo) {
    operator fun invoke(language: String): Flow<Resource<Genres>> = flow {
        try {
            emit(Resource.Loading())
            val res = genresRepo.getGenres(language)
            emit(Resource.Success(res))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.message.toString()))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}