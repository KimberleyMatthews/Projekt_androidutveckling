package com.example.projekt_androidutveckling.api

import retrofit2.Call
import retrofit2.http.GET

interface JokeApi {

    @GET("/inspiration")
    fun getInspiration(): Call<API>
}