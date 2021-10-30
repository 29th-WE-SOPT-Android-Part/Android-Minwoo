package com.example.week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
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

        binding.btnFollower.setOnClickListener{
            val transaction = childFragmentManager.beginTransaction()
            if(position == REPO_POSITION) {
                transaction.replace(R.id.container_home, fragmentFollower).commit()
                position = FOLLOWER_POSITION
            }
        }

        binding.btnRepo.setOnClickListener{
            val transaction = childFragmentManager.beginTransaction()
            if(position == FOLLOWER_POSITION){ // follower일 때만 변경해줌
                transaction.replace(R.id.container_home, fragmentRepo).commit()
                position = REPO_POSITION
            }
        }
    }

    companion object{
        const val FOLLOWER_POSITION = 1
        const val REPO_POSITION = 2
    }

}