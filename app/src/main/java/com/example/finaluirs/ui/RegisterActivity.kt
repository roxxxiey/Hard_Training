package com.example.finaluirs.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.finaluirs.databinding.ActivityRegisterBinding
import com.example.finaluirs.models.User
import com.example.finaluirs.repositories.UserRepository

import kotlinx.coroutines.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var repository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = UserRepository(this)

        binding.btnRegister.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                val success = repository.registerUser(User(0, firstName, lastName, email, password))
                withContext(Dispatchers.Main) {
                    if (success) {
                        finish()
                    } else {
                        binding.tvError.text = "User already exists"
                    }
                }
            }
        }
    }
}
