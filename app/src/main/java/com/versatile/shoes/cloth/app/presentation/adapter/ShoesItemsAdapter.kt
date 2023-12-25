package com.versatile.shoes.cloth.app.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.versatile.shoes.cloth.app.databinding.ShoesItemLayoutBinding
import com.versatile.shoes.cloth.app.presentation.model.ShoesModel

class ShoesItemsAdapter(private val shoesModels: List<ShoesModel>) :
    RecyclerView.Adapter<ShoesItemsAdapter.ShoesItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesItemViewHolder {
        val binding = ShoesItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ShoesItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return shoesModels.size
    }

    override fun onBindViewHolder(holder: ShoesItemViewHolder, position: Int) {
        holder.bind(shoesModels[position])
    }

    inner class ShoesItemViewHolder(private val binding: ShoesItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(shoesModel: ShoesModel) {
            binding.imageOnBoarding.setImageResource(shoesModel.shoesImg)
            binding.textTitle.text = shoesModel.title
        }
    }
}