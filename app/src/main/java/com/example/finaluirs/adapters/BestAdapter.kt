package com.example.finaluirs.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finaluirs.R
import com.example.finaluirs.databinding.BestItemsBinding
import com.example.finaluirs.models.BestModel

class BestAdapter(
    val context: Context,
    val list: List<BestModel>

): RecyclerView.Adapter<BestAdapter.BestViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BestViewHolder {
        val binding = BestItemsBinding.inflate(LayoutInflater.from(context), parent, false)
        return BestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BestAdapter.BestViewHolder, position: Int) {
        val listModel = list[position]

        listModel.getBestTrainImage()?.let { holder.bestTrainImage.setImageResource(it) }
        holder.bestTrainHeading.text = listModel.getBestTrainHeading()
        holder.bestTrainConcept.text = listModel.getBestTrainConxept()
        holder.bestTrainDifficult.text = listModel.getBestTrainDifficult()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class BestViewHolder(binding: BestItemsBinding) : RecyclerView.ViewHolder(binding.root){

        val bestTrainImage = binding.bestTrainImage
        val bestTrainHeading = binding.bestTrainHeading
        val bestTrainConcept = binding.bestTrainConxept
        val bestTrainDifficult = binding.bestTrainDifficult

    }

}