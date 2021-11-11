package com.example.week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.week1.databinding.ActivitySignInBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBtnListener()
    }

    private fun initBtnListener(){
        // val intentLogin = Intent(this, HomeActivity::class.java)
        val intentSignup = Intent(this, SignUpActivity::class.java)

        // btnLogin 버튼 클릭 시 로그인
        binding.btnLogin.setOnClickListener {
            if(binding.etId.text.isNotEmpty() && binding.etPwd.text.isNotEmpty()) { // 아이디, 비밀번호 모두 입력 되어있을 때 homeactivity 로 이동
                // Toast.makeText(this, "박민우님 환영합니다", Toast.LENGTH_SHORT).show()
                // startActivity(intentLogin)
                initNetwork()
            }
            else // 둘 중 하나라도 입력 되지 않았을 때
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
        }

        // btnSignIn 버튼 클릭 시 회원가입 페이지로 이동 -> SignUpActivity
        binding.tvSignUp.setOnClickListener {
            startActivity(intentSignup)
        }
    }

    private fun initNetwork(){ // 네트워크를 초기화하는 함수

        val intentLogin = Intent(this, HomeActivity::class.java)

        val requestLoginData = RequestLoginData(
            email = binding.etId.text.toString(),
            password = binding.etPwd.text.toString()
        )

        // Login에 대한 call 객체 선언
        val callLogin: Call<ResponseLoginData> =  ServiceCreator.basicService.postLogin(requestLoginData)

        callLogin.enqueue(object : Callback<ResponseLoginData> {
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if(response.isSuccessful){
                    val data = response.body()?.data
                    Toast.makeText(this@SignInActivity, "${data?.name}님 환영합니다!", Toast.LENGTH_SHORT).show()
                    startActivity(intentLogin)
                }
                else {
                    Toast.makeText(this@SignInActivity, "올바르지 않은 정보입니다", Toast.LENGTH_SHORT).show()
                    // 더 줄일 수 있지 않을까
                }
            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable){
                Log.e("NetworkTest", "error:$t")
            }
        })
    }
}