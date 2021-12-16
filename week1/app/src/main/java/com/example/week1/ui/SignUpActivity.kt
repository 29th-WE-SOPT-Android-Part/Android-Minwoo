package com.example.week1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week1.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBtnListener()
    }

    private fun initBtnListener(){
        // btn_sigh_up 버튼 클릭 시
        binding.btnSignUp.setOnClickListener{ // 모든 입력이 되어있다면 회원가입 완료 -> 다시 SignInActivity로 이동
            if(binding.etName.text.isNotEmpty() && binding.etId.text.isNotEmpty() && binding.etPwd.text.isNotEmpty() ){
                finish()
            }
            else{ // 모든 입력이 되어 있지 않으면
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }
}