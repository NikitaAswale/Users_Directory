package com.example.users_directory

import retrofit2.http.GET

interface APIService {

    @GET("users")
    suspend fun getUsers() : List<Users>

}