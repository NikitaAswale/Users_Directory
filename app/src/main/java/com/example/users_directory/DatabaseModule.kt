package com.example.users_directory

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideUsersDatabase(@ApplicationContext context: Context): UsersDatabase {
        return Room.databaseBuilder(
            context,
            UsersDatabase::class.java,
            "users_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideUsersDao(database: UsersDatabase): UsersDao {
        return database.usersDao()
    }
}