package com.example.week1

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import com.example.week1.databinding.FragmentProfileBinding
import com.example.week1.databinding.FragmentRepoBinding

class ProfileFragment : Fragment() {
    private var position = FOLLOWER_POSITION
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        initTransactionEvent()
        initImage()
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun initTransactionEvent() {
        val fragmentFollower = FollowerFragment()
        val fragmentRepo = RepoFragment()

        childFragmentManager.beginTransaction().add(R.id.container_home, fragmentFollower).commit()
        binding.btnFollower.isSelected = !binding.btnFollower.isSelected
        binding.btnRepo.isSelected = false

        binding.btnFollower.setOnClickListener{
            // fragment 전환이 해야할 때가 많다면 함수로 만들어서 사용하자
            val transaction = childFragmentManager.beginTransaction()
            if(position == REPO_POSITION) {
                transaction.replace(R.id.container_home, fragmentFollower).commit()
                position = FOLLOWER_POSITION
            }
            binding.btnFollower.isSelected = !binding.btnFollower.isSelected
            binding.btnRepo.isSelected = false
        }

        binding.btnRepo.setOnClickListener{
            val transaction = childFragmentManager.beginTransaction()
            if(position == FOLLOWER_POSITION){ // follower일 때만 변경해줌
                transaction.replace(R.id.container_home, fragmentRepo).commit()
                position = REPO_POSITION
            }
            binding.btnRepo.isSelected = !binding.btnRepo.isSelected
            binding.btnFollower.isSelected = false
        }
    }

    private fun initImage(){
        Glide.with(this)
            .load("https://avatars.githubusercontent.com/u/31370590?v=4")
            .circleCrop()
            .into(binding.ivGithubProfile)
    }


    companion object{
        const val FOLLOWER_POSITION = 1
        const val REPO_POSITION = 2
    }
}