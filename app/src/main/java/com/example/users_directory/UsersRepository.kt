package com.example.users_directory

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersRepository @Inject constructor(
    private val usersDao: UsersDao
){
     fun getUsers(): Flow<List<Users>> = usersDao.getAllUsers()

}