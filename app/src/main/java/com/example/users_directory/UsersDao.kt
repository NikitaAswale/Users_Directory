package com.example.users_directory

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {

    @Query("SELECT * FROM users ORDER BY id DESC")
    fun getAllUsers(): Flow<List<Users>>
}