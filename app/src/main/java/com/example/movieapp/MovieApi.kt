package com.example.movieapp

import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {
    @GET("details/{id}.json")
    suspend fun getMovieDetail(
        @Path("id") movieId: String?
    ):MovieDetail?
}