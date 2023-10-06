package com.lucasgugliuzza.desafiodevexpert.data.remote

import com.lucasgugliuzza.desafiodevexpert.data.dto.MovieResult
import com.lucasgugliuzza.desafiodevexpert.utils.Constans.Companion.API_KEY
import com.lucasgugliuzza.desafiodevexpert.utils.Constans.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


interface MovieApi {

    companion object{
        val instance = Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder().build()).build().create(MovieApi::class.java)
    }

    @GET("discover/movie?api_key=eb3b563dec69f41b827bc5fdac55e670")
    suspend fun getMovies(): MovieResult

//    @GET("movie/{id}?api_key=eb3b563dec69f41b827bc5fdac55e670")
//    suspend fun getDetailMovie(@Path("id")  id: Int): Result<MovieDetail>


}