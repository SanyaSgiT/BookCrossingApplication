package com.example.bookcrossingapplication.data.api

import com.example.bookcrossingapplication.domain.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("user/{id}")
    suspend fun getUser(@Path("id") id: Int): User?
}