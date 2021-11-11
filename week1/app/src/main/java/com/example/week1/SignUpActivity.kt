package com.example.week1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.week1.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                // finish()
                initNetwork()
            }
            else{ // 모든 입력이 되어 있지 않으면
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initNetwork(){ // 네트워크를 초기화하는 함수
        val requestSignUpData = RequestSignUpData(
            name = binding.etName.text.toString(),
            email = binding.etId.text.toString(),
            password = binding.etPwd.text.toString()
        )

        // signUp에 대한 call 객체 선언
        val callSignUp: Call<ResponseSignUpData> =  ServiceCreator.basicService.postSignUp(requestSignUpData)

        callSignUp.enqueue(object : Callback<ResponseSignUpData> {
            override fun onResponse(
                call: Call<ResponseSignUpData>,
                response: Response<ResponseSignUpData>
            ) {
                if(response.isSuccessful){
                    val data = response.body()?.data
                    Toast.makeText(this@SignUpActivity, "${data?.name}님 회원가입을 축하드립니다!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    val message = response.body()?.message
                    Toast.makeText(this@SignUpActivity, "$message", Toast.LENGTH_SHORT).show()
                    // 더 줄일 수 있지 않을까
                }
            }

            override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable){
                Log.e("NetworkTest", "error:$t")
            }
        })
    }
}