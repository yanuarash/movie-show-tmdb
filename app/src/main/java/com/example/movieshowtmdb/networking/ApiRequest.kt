package com.example.kotlintesttmdb.network

import retrofit2.Response
import java.io.IOException

abstract class ApiRequest {
    suspend fun <T: Any> apiRequest(call: suspend () -> Response<T>): T{
        val response = call.invoke()
        if(response.isSuccessful){
            return response.body()!!
        }else{
            val err = response.errorBody()?.string()
            throw IOException(err);
        }

    }
}