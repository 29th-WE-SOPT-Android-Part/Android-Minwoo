# 💻 Week 4 과제 

## 1️⃣ Level 1 필수과제

-----

### 코드 설명

#### 전체적인 코드 설명

세미나에서 배웠듯이 **로그인, 회원가입 서버 통신**을 구현하기 위해 

1. **라이브러리 추가 및 AndroidManifest 설정**
2. **서버 Request / Response 객체 설계**
3. **Retrofit Interface 설계**
4. **Retrofit Interface 실제 구현체(객체) 만들기**
5.  **Callback 등록하여 통신 요청**

의 단계를 거쳐서 해주었다. 

<br

<br><br>

#### 핵심 구현 내용

우선, 회원가입 메서드와 로그인 메서드 모두 구현하기 위해 필요한 Retrofit interface와 Retrofit 객체를 구현해주었고 ,각 메서드의 request body, response body에 해당하는 data Class를 정의해주었다.

##### 회원가입 메서드

`SignUpActivity.kt`에 네트워크를 초기화하는 메서드 `initNetwork()`를 정의해주었고 , 여기에 콜백을 등록해서 data를 서버에서 비동기적으로 받아오도록 구현했고 그 data의 응답에 따라 다른 기능을 하도록 구현해주었다. 

그리고 이 `initNetwork()` 메서드를 `binding.btnSignUp.setOnClickListener`에 넣어줌으로써 각 회원가입 버튼을 눌렀을 때,  서버 통신이 이루어지게 해주었다. 

```kotlin
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
```

<br>

##### 로그인 메서드

회원가입 메서드와 비슷한 맥락으로 구현했다.

<br><br><br>

------

### 막혔던 점, 깨달은 점

+ 각 메서드별로 같은 Retrofit interface와 Retrofit 객체를 사용해도 된다.  

<br><br><br>

-----

### 실행화면 

1. 로그인 화면 - 버튼 클릭 전

   <img src="https://user-images.githubusercontent.com/31370590/141498977-1981653d-c75f-4ce6-a790-0c70ef033949.PNG">

<br>

2. 로그인 화면 - 로그인 버튼 클릭 후

   <img src="https://user-images.githubusercontent.com/31370590/141499079-41cd2ffe-3d83-40be-a99f-0c0d77cc3a3a.PNG">

<br>

3. 회원가입 화면 - 회원가입 버튼 클릭 전

   <img  src="https://user-images.githubusercontent.com/31370590/141499156-b481f097-f541-40f3-83ee-2a726a5095bd.PNG">
   
   <br>
   
4. 회원가입 화면 - 회원가입 버튼 클릭 후

   <img src="https://user-images.githubusercontent.com/31370590/141499233-5f9aeb0a-f177-4d2f-a3f4-cb17d014c668.PNG">
