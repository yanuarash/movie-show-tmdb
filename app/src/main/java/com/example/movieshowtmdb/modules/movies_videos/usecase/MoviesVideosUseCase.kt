package com.example.movieshowtmdb.modules.movies_videos.usecase

import com.example.movieshowtmdb.modules.movies_videos.models.MoviesVideos
import com.example.movieshowtmdb.modules.movies_videos.repo.MoviesVideosRepo
import com.example.movieshowtmdb.networking.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class MoviesVideosUseCase constructor(private val moviesVideosRepo: MoviesVideosRepo) {
    operator fun invoke(movieId: Int): Flow<Resource<MoviesVideos>> = flow {
        try {
            emit(Resource.Loading())
            val res = moviesVideosRepo.getMoviesVideos(movieId)
            emit(Resource.Success(res))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.message.toString()))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}