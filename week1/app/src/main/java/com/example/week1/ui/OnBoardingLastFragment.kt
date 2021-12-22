package com.example.week1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.week1.R
import com.example.week1.databinding.FragmentOnBoardingLastBinding

class OnBoardingLastFragment : Fragment() {
    private var _binding: FragmentOnBoardingLastBinding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingLastBinding.inflate(layoutInflater, container, false)

        binding.btnStartSignIn.setOnClickListener{
            findNavController().navigate(R.id.action_onBoardingLastFragment_to_signInActivity)
            requireActivity().finish()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}