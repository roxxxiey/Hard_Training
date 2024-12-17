package com.example.finaluirs.repositories

import android.content.Context
import com.example.finaluirs.database.AppDatabase
import com.example.finaluirs.models.User


class UserRepository(context: Context) {
    private val userDao = AppDatabase.getDatabase(context).userDao()

    suspend fun registerUser(user: User): Boolean {
        val exists = userDao.checkUserExists(user.email)
        return if (exists == null) {
            userDao.insertUser(user)
            true
        } else {
            false
        }
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.getUser(email, password)
    }
}
