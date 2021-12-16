package com.example.week1.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) { // 여기서는 Activty에 ViewPager가 들어갈것 이므로
    val fragments = mutableListOf<Fragment>()

    // Adapter가 가지고 있는 data set 안에서의 전체 아이템 수를 리턴하는 메소드
    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}