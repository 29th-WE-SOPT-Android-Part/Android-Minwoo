package com.example.week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.week1.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeTabViewAdapter: HomeTabViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        initAdapter()
        initTablayout()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter(){
        val fragmentList = listOf(EmptyFollowerFragment(), EmptyFollowingFragment())

        homeTabViewAdapter = HomeTabViewAdapter(this)
        homeTabViewAdapter.fragments.addAll(fragmentList)

        binding.vpGithubHome.adapter = homeTabViewAdapter
    }

    private fun initTablayout(){
        val tablabel = listOf("팔로잉", "팔로워")

        TabLayoutMediator(binding.tlGithubHome, binding.vpGithubHome) {tab, position ->
            tab.text = tablabel[position] // 페이지 개수만큼 tab 생성
        }.attach()
    }
}