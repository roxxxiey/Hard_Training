package com.example.finaluirs.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> get() = _userName

    private val _firstName = MutableLiveData<String>()
    val firstName: LiveData<String> get() = _firstName

    private val _lastName = MutableLiveData<String>()
    val lastName: LiveData<String> get() = _lastName

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    // Инициализация данных пользователя
    fun setUserData(firstName: String, lastName: String, email: String) {
        _firstName.value = firstName
        _lastName.value = lastName
        _email.value = email
        _userName.value = "$firstName $lastName"
    }
}
