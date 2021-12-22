package com.example.week1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.week1.ui.adapter.HomeViewPagerAdapter
import com.example.week1.R
import com.example.week1.databinding.ActivityHomeBinding
import java.util.*

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeViewPagerAdapter: HomeViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        // initTransactionEvent()
        initAdapter()
        initBottomNavigation()
        setContentView(binding.root)
    }


    // ViewPager2와 Fragment 연동
    private fun initAdapter() {
        val fragmentList = listOf(ProfileFragment(), HomeFragment())

        homeViewPagerAdapter = HomeViewPagerAdapter(this)
        homeViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpHome.adapter = homeViewPagerAdapter
    }

    // ViewPager2와 BottomNavigationView 연동
    private fun initBottomNavigation() {

        // ViewPager2의 페이지, 즉 프래그먼트 중 하나가 선택된 경우 그에 해당하는 하단탭 체크
        binding.vpHome.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bnvHome.menu.getItem(position).isChecked = true
            }
        })

        // 체크된 item의 Resource Id 값으로 어떤 아이템이 선택되었는지를 구분
        binding.bnvHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_profile -> {
                    binding.vpHome.currentItem = PROFILE_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                R.id.menu_home -> {
                    binding.vpHome.currentItem = HOME_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                else -> {
                    binding.vpHome.currentItem = CAMERA_FRAGMENT
                    return@setOnItemSelectedListener true
                }
            }
        }
    }


    companion object{
        const val PROFILE_FRAGMENT = 0
        const val HOME_FRAGMENT = 1
        const val CAMERA_FRAGMENT = 2
    }

    /*
    private fun initTransactionEvent() {
        val fragmentFollower = FollowerFragment()
        val fragmentRepo = RepoFragment()

        supportFragmentManager.beginTransaction().add(R.id.container_home, fragmentFollower).commit()

        binding.btnFollower.setOnClickListener{
            val transaction = supportFragmentManager.beginTransaction()
            if(position == REPO_POSITION) {
                transaction.replace(R.id.container_home, fragmentFollower).commit()
                position = FOLLOWER_POSITION
            }
        }

        binding.btnRepo.setOnClickListener{
            val transaction = supportFragmentManager.beginTransaction()
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
    */
}