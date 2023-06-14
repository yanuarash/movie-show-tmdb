package com.example.movieshowtmdb.modules.movies_detail.usecase

import com.example.movieshowtmdb.modules.movies_detail.models.MoviesDetail
import com.example.movieshowtmdb.modules.movies_detail.repo.MoviesDetailRepo
import com.example.movieshowtmdb.networking.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class MoviesDetailUseCase constructor(private val moviesDetailRepo: MoviesDetailRepo) {
    operator fun invoke(movieId: Int): Flow<Resource<MoviesDetail>> = flow {
        try {
            emit(Resource.Loading())
            val res = moviesDetailRepo.getMoviesDetail(movieId)
            emit(Resource.Success(res))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.message.toString()))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}