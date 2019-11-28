package com.example.movieapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{

        private var movieApi: MovieApi? = null
        private const val BASE_URL = "https://movie-app-24721.firebaseio.com/"

        @JvmStatic
        fun getMovieApi(): MovieApi{
            if(movieApi ==null){
                movieApi = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MovieApi::class.java)
            }
            return movieApi !!
        }
    }
}