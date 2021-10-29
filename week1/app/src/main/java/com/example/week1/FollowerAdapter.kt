package com.example.week1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.databinding.ItemFollowerListBinding

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>(){
    val followerList  = mutableListOf<FollowerData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FollowerAdapter.FollowerViewHolder {
        val binding = ItemFollowerListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(followerList[position])
    }

    override fun getItemCount(): Int = followerList.size

    class FollowerViewHolder(private val binding: ItemFollowerListBinding)
        : RecyclerView.ViewHolder(binding.root){
            fun onBind(data: FollowerData){
                binding.tvFollowerName.text = data.name
                binding.tvFollowerInfo.text = data.info
            }
        }
}