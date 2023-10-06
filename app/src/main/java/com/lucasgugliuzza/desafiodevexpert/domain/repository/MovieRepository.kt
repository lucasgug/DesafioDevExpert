package com.lucasgugliuzza.desafiodevexpert.domain.repository


import com.lucasgugliuzza.desafiodevexpert.data.dto.ResultDto
import com.lucasgugliuzza.desafiodevexpert.data.remote.MovieApi


class MovieRepository( private val api: MovieApi ) {

    suspend fun getMovies(): Result<List<ResultDto>> {
        return try {

            val response = api.getMovies().results
//            val characters = response.map { it.toMovieResponse() }
            Result.success(response)


        } catch (e: Exception) {
            Result.failure(e)
        }

    }
}


