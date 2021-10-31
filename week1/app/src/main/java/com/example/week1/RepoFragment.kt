package com.example.week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week1.databinding.FragmentRepoBinding

class RepoFragment : Fragment() {

    private lateinit var repoAdapter: RepoAdapter
    private var _binding: FragmentRepoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepoBinding.inflate(layoutInflater, container, false)
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
        binding.rvRepo.addItemDecoration(decoration)
    }

    private fun initAdapter(){
        repoAdapter = RepoAdapter()

        binding.rvRepo.adapter = repoAdapter

        repoAdapter.repoList.addAll(
            listOf(
                RepoData("안드로이드 과제 레포지토리", "안드로이드 파트 과제"),
                RepoData("안드로이드 과제 레포지토리", "안드로이드 파트 과제"),
                RepoData("안드로이드 과제 레포지토리", "안드로이드 파트 과제")
            )
        )

        repoAdapter.notifyDataSetChanged()
    }
}