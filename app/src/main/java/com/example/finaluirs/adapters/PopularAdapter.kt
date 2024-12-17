package com.example.finaluirs.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finaluirs.databinding.PlansItemsBinding
import com.example.finaluirs.models.PopularModel
import com.example.finaluirs.ui.WorkoutDetails

class PopularAdapter(
    val context : Context,
    val list: ArrayList<PopularModel>

): RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularAdapter.PopularViewHolder {
        val binding = PlansItemsBinding.inflate(LayoutInflater.from(context), parent, false)
        return PopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularAdapter.PopularViewHolder, position: Int) {

        val listModel = list[position]

        holder.trainFirstName.text = listModel.getFirstName()
        holder.trainSecondName.text = listModel.getSecondName()
        holder.trainDifficult.text = listModel.getTrainDifficult()
        listModel.getTrainImage()?.let { holder.trainImage.setImageResource(it) }

        holder.item.setOnClickListener{
            val intent = Intent(context, WorkoutDetails :: class.java)
            intent.putExtra("workoutImage", listModel.getTrainImage())
            intent.putExtra("workoutName", listModel.getFirstName())
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class PopularViewHolder(binding : PlansItemsBinding): RecyclerView.ViewHolder(binding.root) {

        val trainImage = binding.planImage
        val trainFirstName = binding.heading
        val trainSecondName = binding.concept
        val trainDifficult = binding.difficult

        val item = binding.root

    }

}