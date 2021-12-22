# 💻 Week 7 과제 

## 1️⃣ Level 1 필수과제

-----

### 📌 1 - 1 온보딩

+ Navigation component를 이용해 온보딩 화면에 들어갈 각 프래그먼트를 OnBoarding Activity에 띄워주었다.
+ 라이브러리를 추가하고, Navigation graph를 만들고, OnBoarding Activity를 NavHostFragment로 지정하고, 화면에 나타날 프래그먼트를 생성하고, Navigation graph에 작업을 명세하고, 코드단에서 각 프래그먼트 전환 로직을 추가해주었다.
+ 그리고 마지막 온보딩 화면 후, 로그인 화면으로 이동해야 하기 때문에 Navigation graph에 SignInActivity도 추가해 마지막 온보딩 프래그먼트에서 SignInActivity로 전환되는 action도 만들어주었다. 

<br>

-----

### 📌 1 - 2 SharedPreferences

+ SharedPreferences를 object로 구현해주어 사용하기 쉽게 만들어주었다.

  ```kotlin
  
  object AutoLoginSharedPreferences {
      private const val STORAGE_KEY = "USER_AUTH"
      private const val AUTO_LOGIN = "AUTO_LOGIN"
  
      fun getAutoLoginSharedPreferences(context: Context): SharedPreferences {
          return context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
      }
  
      fun getAutoLogin(context: Context): Boolean = getAutoLoginSharedPreferences(context).getBoolean(
          AUTO_LOGIN, false
      )
  
  
      fun setAutoLogin(context: Context, value: Boolean) {
          getAutoLoginSharedPreferences(context)
              .edit()
              .putBoolean(AUTO_LOGIN, value)
              .apply()
      }
  
  
      fun removeAutoLogin(context: Context) {
          getAutoLoginSharedPreferences(context)
              .edit()
              .remove(AUTO_LOGIN)
              .apply()
      }
  
  
      fun clearAutoLogin(context: Context) {
          getAutoLoginSharedPreferences(context)
              .edit()
              .clear()
              .apply()
      }
  
  }
  ```

  + ` getAutoLoginSharedPreferences()` 메서드를 구현해줌으로써 보일러 플레이트 코드를 완화해주었다.

<br>

-----

### 📌 1- 3 Util class 및 패키징 방식

##### Util class

+ util class란 쉽게 말하자면 프로젝트 내부에서 **자주 사용하는 함수들을 static하게 선언**해서 **모든 클래스에서 접근할 수 있게** 모아둔 클래스이다.
+ 아직까지 Util class에서 사용하는 코드는 없다.

<br>

#### 패키징 방식

+ 세미나에서 배운 것과 동일한 방식으로 패키징을 진행했다.

+ data
  + local - 로컬 데이터 로직과 관련된 클래스들을 모아둠
  + remote - 서버 데이터 로직
+ ui - activity나 fragment와 같이 화면을 구성하는 클래스를 모아둠
  + adapter - 각종 어뎁터를 모아 놓음
+ util - util 클래스나 확장함수

<br>

------

### 막혔던 점, 깨달은 점

+ fragment에서 activity로 화면 전환을 할 때

  `startActivity(Intent(context, SettingActivity::class.java))`를 사용한다.

<br><br><br>

-----

### 실행화면 

<img src = "https://user-images.githubusercontent.com/31370590/146523819-0bd258df-7536-42e7-9a9d-dda22ad78db7.gif" width = "400" height = "800">



<br>

<img src = "https://user-images.githubusercontent.com/31370590/146524182-2d0c76d3-0183-4698-932b-8ceb2415e362.gif" width = "400" height = "800">

<br>

<img src = "https://user-images.githubusercontent.com/31370590/146526255-56d15e6a-e508-4310-8aa7-0dc6b56286e4.gif" width = "400" height = "800">

<br>

<img src = "https://user-images.githubusercontent.com/31370590/146526357-728249c9-b766-4e69-988b-275f3d1220bb.gif" width = "400" height = "800">

​	
