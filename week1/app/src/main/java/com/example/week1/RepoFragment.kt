package com.example.week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
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
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter(){
        repoAdapter = RepoAdapter()

        binding.rvRepo.adapter = repoAdapter

        repoAdapter.repoList.addAll(
            listOf(
                RepoData("안드로이드 과제 레포지토리", "역시 솝트 안드로이드 과제가 최우선"),
                RepoData("알고리즘 과제 레포지토리", "알고리즘 과제"),
                RepoData("컴퓨터 네트워크 과제 레포지토리", "컴퓨터 네트워크 과제"),
                RepoData("리눅스 레포지토리", "리눅스 과제")
            )
        )

        repoAdapter.notifyDataSetChanged()
    }
}