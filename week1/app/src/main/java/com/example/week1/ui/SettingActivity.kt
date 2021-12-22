package com.example.week1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week1.R
import com.example.week1.databinding.ActivitySettingBinding
import com.example.week1.util.AutoLoginSharedPreferences

class SettingActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initListener()
    }

    private fun initListener(){
        binding.cbAutoLogin.setOnClickListener{
            if(binding.cbAutoLogin.isChecked){
                disableAutoLogin()
                Toast.makeText(this, "자동 로그인 해제", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private fun disableAutoLogin() {
        AutoLoginSharedPreferences.removeAutoLogin(this)
    }
}