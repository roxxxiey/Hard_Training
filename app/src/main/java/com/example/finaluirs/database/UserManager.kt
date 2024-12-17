package com.example.finaluirs.database

import android.content.Context

class UserManager(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun saveUser(firstName: String, lastName: String, email: String) {
        sharedPreferences.edit().apply {
            putString("first_name", firstName)
            putString("last_name", lastName)
            putString("email", email)
            apply()
        }
    }

    fun getFirstName(): String? = sharedPreferences.getString("first_name", "Default First")
    fun getLastName(): String? = sharedPreferences.getString("last_name", "Default Last")
    fun getEmail(): String? = sharedPreferences.getString("email", "default@email.com")
}
