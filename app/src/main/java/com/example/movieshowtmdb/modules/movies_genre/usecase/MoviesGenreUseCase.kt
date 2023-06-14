package com.example.movieshowtmdb.modules.movies_genre.usecase

import com.example.kotlintesttmdb.models.MoviesGenre
import com.example.kotlintesttmdb.network.Resource
import com.example.kotlintesttmdb.network.repo.MoviesGenreRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class MoviesGenreUseCase constructor(private val moviesGenreRepo: MoviesGenreRepo) {
    operator fun invoke(page: Int, withGenres: String): Flow<Resource<MoviesGenre>> = flow{
        try {
            emit(Resource.Loading())
            val res = moviesGenreRepo.getMoviesGenre(page, withGenres)
            emit(Resource.Success(res))
        }
        catch (e: HttpException){
            emit(Resource.Error(message = e.message.toString()))
        }
        catch (e: IOException){
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}