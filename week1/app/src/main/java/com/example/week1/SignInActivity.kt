package com.example.week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week1.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBtnListener()
    }

    private fun initBtnListener(){
        val intentLogin = Intent(this, HomeActivity::class.java)
        val intentSignup = Intent(this, SignUpActivity::class.java)

        // btnLogin 버튼 클릭 시 로그인
        binding.btnLogin.setOnClickListener {
            if(binding.etId.text.isNotEmpty() && binding.etPwd.text.isNotEmpty()) { // 아이디, 비밀번호 모두 입력 되어있을 때 homeactivity 로 이동
                Toast.makeText(this, "박민우님 환영합니다", Toast.LENGTH_SHORT).show()
                startActivity(intentLogin)
            }
            else // 둘 중 하나라도 입력 되지 않았을 때
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
        }

        // btnSignIn 버튼 클릭 시 회원가입 페이지로 이동 -> SignUpActivity
        binding.tvSignUp.setOnClickListener {
            startActivity(intentSignup)
        }
    }
}