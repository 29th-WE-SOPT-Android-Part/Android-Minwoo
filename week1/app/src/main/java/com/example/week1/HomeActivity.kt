package com.example.week1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    // private var position = FOLLOWER_POSITION
    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeViewPagerAdapter: HomeViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        // initTransactionEvent()
        initAdapter()
        setContentView(binding.root)
    }


    private fun initAdapter() {
        val fragmentList = listOf(ProfileFragment(), HomeFragment())

        homeViewPagerAdapter = HomeViewPagerAdapter(this)
        homeViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpHome.adapter = homeViewPagerAdapter
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