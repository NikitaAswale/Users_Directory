package com.example.users_directory

class UsersRepository {

    private val api = RetrofitInstance.api

    suspend fun getUsers(): List<Users> {
        return try {
            api.getUsers()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

}