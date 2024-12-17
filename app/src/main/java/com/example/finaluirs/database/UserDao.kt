package com.example.finaluirs.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.finaluirs.models.User

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    suspend fun getUser(email: String, password: String): User?

    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun checkUserExists(email: String): User?
}
