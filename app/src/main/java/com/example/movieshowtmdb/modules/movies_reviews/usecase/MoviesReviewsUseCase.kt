package com.example.movieshowtmdb.modules.movies_reviews.usecase

import com.example.kotlintesttmdb.models.MoviesReviews
import com.example.kotlintesttmdb.network.Resource
import com.example.kotlintesttmdb.network.repo.MoviesReviewsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class MoviesReviewsUseCase constructor(private val moviesGenreRepo: MoviesReviewsRepo) {
    operator fun invoke(movieId: Int, page: Int): Flow<Resource<MoviesReviews>> = flow {
        try {
            emit(Resource.Loading())
            val res = moviesGenreRepo.getMoviesReviews(movieId, page)
            emit(Resource.Success(res))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.message.toString()))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}