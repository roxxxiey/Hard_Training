package com.example.finaluirs.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finaluirs.R
import com.example.finaluirs.databinding.ActivityWorkoutDetailsBinding

class WorkoutDetails : AppCompatActivity() {

    private lateinit var binding: ActivityWorkoutDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val workoutImage = intent.getIntExtra("workoutImage", 0)
        val workoutName = intent.getStringExtra("workoutName")

        binding.workoutImage.setImageResource(workoutImage)
        binding.workoutName.text = workoutName

        binding.backhome.setOnClickListener{
            finish()
        }
    }
}