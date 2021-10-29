package com.example.week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week1.databinding.FragmentFollowerBinding


class FollowerFragment : Fragment() {

    private lateinit var followerAdapter: FollowerAdapter
    private var _binding: FragmentFollowerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)
        initAdapter()
        decoRecyclerView()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun decoRecyclerView(){
        val decoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        binding.rvFollower.addItemDecoration(decoration)
    }

    private fun initAdapter(){
        followerAdapter = FollowerAdapter()

        binding.rvFollower.adapter = followerAdapter

        followerAdapter.followerList.addAll(
            listOf(
                FollowerData("박민우", "안드로이드 YB"),
                FollowerData("한승현", "안드로이드 OB"),
                FollowerData("김혜인", "안드로이드 YB"),
                FollowerData("김서버", "서버 파트장"),
                FollowerData("박기획", "기획 파트장"),
                FollowerData("최아요", "IOS 파트장")
            )
        )

        followerAdapter.notifyDataSetChanged()
    }
}