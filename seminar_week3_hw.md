# 💻 Week 3 과제 

## 1️⃣ Level 1 필수과제

-----

### 코드 설명

#### 전체적인 코드 설명

2주차 과제에서는`HomeActivity`에 버튼 두개를 추가하고 각 버튼을 누를 때마다 `HomeActivity`안에 위치해있는 Fragement들이 교체되도록 해주고, 각 Fragment에는 서로 다른 정보를 표시하는 RecyclerView를 배치해주었다. 

이번주 과제에서는 `HomeActivity`에 `ViewPager2`와 `BottomNavigationView`를 배치하고 이를 서로 연동시켜주어서 화면을 스와이프하거나 BottomNavigationView의 각 메뉴를 선택하면 ViewPager2의 Fragment들이 전환될 수 있도록 해주었고, 여기 들어가는 Fragment로 `ProfileFragment`, `HomeFragment`를 만들어주었다.

그리고 `ProfileFragment`에는 저번주 과제처럼 각 버튼을 누르면 `FragmentContainerView`에 담긴 Fragment 들이 전환되도록 해주고, 각 `FollowerFragment`, `RepoFragment`에는 팔로워 정보, 레포지토리 정보를 표시하는 RecyclerView를 배치해주었다.

`HomeFragment`에는 `TabLayout`과 `ViewPager2`를 배치해 `EmptyFollowerFragment`, `EmptyFollowingFragment`를 배치해주었다. 

<br><br>

#### 전체적인 구조

HomeActivity

+ ViewPager2
  + ProfileFragment
    + FragmentContainerView
      + FollowerFragment
      + RepoFragment
  + HomeFragement
    + TabLayout
    + ViewPager2
      + EmptyFollowerFragment
      + EmptyFollowingFragment
+ BottomNavigation

<br><br>

#### 핵심 구현 내용

##### ViewPager2와 BottomNavigation을 이용한 Frament 전환

1. ViewPager2 만들기
   1. 전환할 Fragment 생성
   2. Activity내에서 Fragment를 전환하기 위해 **ViewPager2 배치**
   3. **Adapter 만들기**(Fragment나 FragmentActivity 둘중 하나 권장)
   4. ViewPager2와 Adapter 연동하기
2. ViewPager와 BottomNavigation 연동하기
   1. 하단탭(BottomNavigation)에 사용할 **아이콘 만들기**
   2. 하단탭(BottomNavigation)에서 보여줄 **메뉴`menu.xml` 만들기**
   3. **메뉴 아이콘 색상 설정**
   4. Activity **Layout에 BottomNavigationView 추가**
   5. BottomNavigationView와 ViewPager2 연동

<br>

##### TabLayout을 활용하여 ViewPager2 구현하기

1. Fragment 레이아웃에 **`Tablayout` 추가**
2. `Tablayout` 추가한 Fragment 레이아웃에 **ViewPager2도 추가해서 배치**한다.  
3. ViewPager2에 넣어줄 **Fragment 2개 생성**
4. **Adapter 만들기**
5. ViewPager2와 Tablayout 연동하기

<br><br>

#### 기타 구현 내용

+ 이미지 뷰에 쓸 이미지를 피그마에서 png 파일로 export해서 9-patch해서 사용하거나 SVG 파일로 export해 새로운 xml파일을 만들어서 사용했다. 
+ editText를 **selector**를 활용해서 focus 되었을 때, 안 되었을 때를 구분해 디자인
+ 간단한 도형들은 **ShapeDrawble**을 이용해 직접 만들어서 사용했다. 

+ fontfamily 파일을 만들고 각 font를 fontWeight 값에 따라 구별해서 사용해주었다. 

+ textsize, margin, font 등 여러 디자인 요소들을 피그마, 제플린 값에 맞게 수정해주었다. 

+ Fragment에서의 viewbinding

  `_binding` 변수를 nullable한 변수로 선언해주고 kotlin property를 활용해 `binding` 변수의 getter를 정의해주었다.  좀비 객체의 생성을 방지하기 위해 `onDestroyView()`에서 binding 객체 참조를 해제해주었다.

+ glide를 이용해 이미지를 처리해주었다. 

<br><br>

------

### 막혔던 점, 깨달은 점

##### svg 파일 사용

+ `svg` 파일을 사용하려면,  `svg` 파일을 export해서 (drawble 폴더가 아닌) res 폴더에 넣은 후, `drawble => new => vector asset => local file` 순서로 선택해 path 지정할 때 res 폴더에 있는 svg 파일을 참조해 새로운 xml을 파일을 만들면 된다.

<br>

##### Fragment 내에서 하위 Fragment 전환

+ 액티비티에서 `FragmentContainerView`에 담긴 하위 프래그먼트들을 전환해줄때는 `supportFramnetManger()`를 사용했지만,

  `ProfileFragment`에서 즉, 프래그먼트에서 프래그먼트 간 전환을 해주기위해서는 다른 방법을 사용한다. 프래그먼트는 하나 이상의 프래그먼트를 호스팅할 수 있다(담을 수 있다). 프래그먼트 내에서 자식 프래그먼트를 관리하는 FragmentManager 에 접근하기 위해서 `getChildFragmentManager()`를 사용한다. 그리고 자식 프래그먼트에서 부모의 FragmentManager 에 접근하기 위해서는`getParentFragmentManager()` 를 사용하면 된다.

  >  [참고](https://velog.io/@ejjjang0414/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-Fragment-manager)

<br>

##### resource not found 오류

+ 파일들이 멀쩡히 존재하는데도 불구하고 갑자기 resource not found 오류가 발생했다. 이는 알고보니 xml 파일에서 `<?xml version="1.0" encoding="utf-8"?>`을 두 번 써서 생기는 문제였다. 앞으로 주의하자

<br>

##### button design selector  

+ selector를 이용해 버튼을 디자인하려고 했는데, 왜 인지 모르게

  `app:background="@drawable/selector_github_btn"`를 해도 적용이 안됐다. 여러 방법을 해봐도 안되서 결국 팟장님한테 물어본 결과

  ```kotlin
  binding.btnFollower.setOnClickListener{
              // fragment 전환이 해야할 때가 많다면 함수로 만들어서 사용하자
              val transaction = childFragmentManager.beginTransaction()
              if(position == REPO_POSITION) {
                  transaction.replace(R.id.container_home, fragmentFollower).commit()
                  position = FOLLOWER_POSITION
              }
              binding.btnFollower.isSelected = !binding.btnFollower.isSelected
              binding.btnRepo.isSelected = false
          }
  
          binding.btnRepo.setOnClickListener{
              val transaction = childFragmentManager.beginTransaction()
              if(position == FOLLOWER_POSITION){ // follower일 때만 변경해줌
                  transaction.replace(R.id.container_home, fragmentRepo).commit()
                  position = REPO_POSITION
              }
              binding.btnRepo.isSelected = !binding.btnRepo.isSelected
              binding.btnFollower.isSelected = false
          }
  ```
  
  이렇게 코드단에서 각 버튼의 listener에 `binding.btnRepo.isSelected = !binding.btnRepo.isSelected`, `binding.btnFollower.isSelected = false`를 넣어줌으로써 해결했다.
  
  > 근데 아직도 왜 selector로 하면 적용이 안되는지 모르겠다
  
  <br>
  
  그리고 xml 파일에서 각 버튼의 속성을 이렇게 주었다.
  
  ```kotlin
   android:textColor="@drawable/selector_text_color"        android:background="@drawable/selector_github_btn"
  ```

<br><br><br>

-----

### 실행화면 

1. 로그인 화면

   <img src = "https://user-images.githubusercontent.com/31370590/139588397-13f867a6-239c-4f66-bbd9-68af0fecc105.PNG" width = "250" height = "450">

<br>

2. 아이디와 비밀번호 입력 후 로그인 버튼 클릭 시, `HomeActivity`로 전환 

   <img src = "https://user-images.githubusercontent.com/31370590/139588404-d222a54d-210b-4e83-aede-fe68ebc090be.PNG" width = "250" height = "450">

<br>

3. 각 버튼을 누르면 프래그먼트가 전환되고 이에 따라 리사이클러뷰에서 해당하는 data 표시해줌

   <img src = "https://user-images.githubusercontent.com/31370590/139588420-b6003d05-ac2e-4a79-b067-a32d79b7c985.PNG" width = "250" height = "450">
   
   <br>
   
4. 스와이프하거나 BottomNavigation의 홈 메뉴를 누르면 HomeFragment로 전환됨

   <img src = "https://user-images.githubusercontent.com/31370590/139588445-8ddfcb54-0f10-47c0-ab11-16f54c30da35.PNG" width = "250" height = "450">

   <br>

5. Tablayout의 팔로워를 누르면 Fragment가 전한됨

   <img src = "https://user-images.githubusercontent.com/31370590/139588486-4f287ba5-2990-484d-99ae-8d6f7e25296e.PNG" width = "250" height = "450">
