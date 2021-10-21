# 세미나 1주차 과제

## Level1 필수과제

### 코드 설명

<br>

#### SignInActivity

```kotlin
private lateinit var binding : ActivitySignInBinding
```

+ 뷰 참조를 위한 binding 객체 선언

<br>

```kotlin
binding.btnLogin.setOnClickListener {
    if(binding.etId.text.isNotEmpty() && binding.etPwd.text.isNotEmpty()) { // 아이디, 비밀번호 모두 입력 되어있을 때 homeactivity 로 이동
        Toast.makeText(this, "박민우님 환영합니다", Toast.LENGTH_SHORT).show()
        startActivity(intent_login)
    }
    else // 둘 중 하나라도 입력 되지 않았을 때
        Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
}
```

+ editText에 내용이 입력되어있는지를 확인하기 위해 `binding.etId.text.isNotEmpty()` 를 사용
+ `startActivity(intent_login)`을 통해 액티비티간 화면 전환 

<br>

<br>

<br>

#### SignUpActivity

```kotlin
if(binding.etName.text.isNotEmpty() && binding.etId.text.isNotEmpty() && binding.etPwd.text.isNotEmpty() ){
    finish()
}
```

+ `finish()` method를 통해 현재 Activity를 종료 => 백스택에서 제거	

<br>

<br>

<br>

#### activity_sign_in.xml

+ textview와 editText의 테두리에 동일한 색깔을 설정하기 위해 `res/values/colors.xml`에 sopt_color를 지정해줌.

  ```xml
  <color name="Sopt_color">#FF83B9</color>
  ```

<br>

+ editText와 button을 더 이쁘게 디자인하게 위해 `button_background.xml`과 `edittext_background.xml`을 만들고, 

  EditText의 background 속성에 android:background="@drawable/edittext_background"를 주고, Button의 background 속성에 android:background="@drawable/button_background" 를 주었다. 

  > 특히 여기서 button에 background 속성을 줘도 기본 보라색 배경이 계속 유지되어, 이를 `res/values/themes/themes.xml`에서 <style name="Theme.Week1" parent="Theme.AppCompat.Light">로 변경해줌으로써 해결했다. 

<br>

+ editText에서 text가 너무 앞에 붙어있어서 답답한 느낌이 들어 속성에 padding을 주어 이를 해결함.

<br>

+ editTextView에서 `android:inputType="textPassword"` 속성을 주어 비밀번호를 입력할 때 입력내용이 가려지도록 했다. 

<br>

<br>

<br>

-----

### 실행화면 

1. 앱 처음 실행 시, `SignInActivity`가 화면에 표시됨

<img src = "https://user-images.githubusercontent.com/31370590/136657827-e153f3f9-4507-4a20-8b2e-6e3dd6817979.PNG" width = "250" height = "450">

<br>

2. 회원가입 버튼 클릭 시, `SignUpActivity`로 이동 

<img src = "https://user-images.githubusercontent.com/31370590/136657955-71cda1be-c361-4411-a834-36c73d857999.PNG" width = "250" height = "450">

<br>

3. 이름, 아이디, 비밀번호 중 하나라도 입력이 안 되어있다면 toast 메시지 출력, 다 입력되어 있다면 다시 `SignInActivity`로 이동

<img src = "https://user-images.githubusercontent.com/31370590/136657979-7a10c388-6193-4437-87b2-64d6e8e476e4.PNG" width = "250" height = "450">

<br>

4. 아이디와 비밀번호를 입력하고 로그인 버튼을 누르면 `HomeActivity`로 이동

<img src = "https://user-images.githubusercontent.com/31370590/136658016-9e4b8853-326c-4596-8a3b-7701455f8729.PNG" width = "250" height = "450">