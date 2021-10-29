# 💻 Week 2 

## 1️⃣ Level 1 필수과제

### 코드 설명

<br>

#### 지난 과제 피드백 내용 반영

+ 변수명의 경우 **lowerCamelCase**를 원칙으로 작성하려고 노력함
+ `onCrete()` method에 모든 기능을 다 넣지 않고, `private fun function()~` 처럼 함수화를 통해 코드의 가독성을 높였음.

<br><br>

#### 전체적인 코드 설명

지난 과자의 내용에서 Fragment와 RecyclerView 부분만 추가해주었다. `HomeActivity`에 버튼 두개를 추가하고 각 버튼을 누를 때마다 `HomeActivity`안에 위치해있는 Fragement들이 교체해도록 해주고, 각 Fragment에는 서로 다른 정보를 표시하는 RecyclerView를 배치해주었다. 

<br><br>

#### Fragment

+ layout 파일에 `name` 속성을 통해 직접 배치할 수도 있지만 유동적으로 fragment의 추가/교체/삭제를 용이하게 해주기 위해 프로그래밍적으로 배치

+ `FragmentContainerView`를 xml에 배치해놓고 class안에서 `supportFragmentManager`를 이용해 버튼 클릭에 따라 fragment를 교체해주었다. 

+ Fragment에서의 Viewbinding

  ```kotlin
  private var _binding: FragmentFollowerBinding? = null
  private val binding get() = _binding!!
  ```

  `_binding` 변수를 nullable한 변수로 선언해주고 kotlin property를 활용해 `binding` 변수의 getter를 정의해주었다.  

  ```kotlin
  override fun onDestroyView() {
          super.onDestroyView()
          _binding = null
      }
  ```

  그리고 좀비 객체의 생성을 방지하기 위해 `onDestroyView()`에서 binding 객체 참조를 해제해주었다.

<br>

#### RecyclerView

##### RecyclerView 작업순서

1. 리스트에 반복적으로 보여질 **아이템의 Layout(xml) 만들기**
2. 아이템의 **data class** 만들기
3. 아이템 뷰의 UI요소를 가지고 있는 **ViewHolder** 만들기
4. ViewHolder를 생성하고 ViewHolder에 데이터를 전달하는 **Adapter**만들기
5. **RecyclerView** 배치하기
6. RecyclerView 아이템의 **배치방향(가로/세로/격자)** 확인하기(LayoutManager)
7. RecyclerView에 **Adapter** 연결하기
8. Adapter의 **데이터 갱신**하기

위의 세미나 내용을 기반으로 RecyclerView를 구현해주었다.

<br>

#### 기타

+ 아이템 레이아웃인 `item_repo_list.xml`의 `textView`에  `maxLines`, `ems`, `ellipsize` 등의 속성을 넣어줌으로써 텍스트가 일정 범위를 넘어가면 줄임표로 표시해주었다. 

  ```kotlin
  android:maxLines="1"
  android:ems="10"
  android:ellipsize="end"
  ```

<br>

+ `RepoFragment`의 recyclerVeiw는 GridLayout 속성을 주었다. 

  ```kotlin
  app:layoutManager="androidx.recyclerview.widget.GridLayoutManager"
  app:spanCount="2"
  ```

<br>

+ `decoRecyclerView()` 함수를 정의해 리스트 간 간단한 구분선을 넣어줬다. 

```
private fun decoRecyclerView(){
    val decoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
    binding.rvFollower.addItemDecoration(decoration)
}
```

<br><br>

### 막혔던 점

```kotlin
//  val transaction = supportFragmentManager.beginTransaction()

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
```

처음에는 이 코드에서 `transaction` 변수가 `btnFollower`와 `btnRepo`의 각 리스너에서 모두 사용되니 이를 단순히 listener 밖으로 빼서 공유해서 사용해주었더니, 아래와 같은 오류가 발생했다. 

```kotlin
java.lang.IllegalStateException: commit already called
```

=>

`transaction`변수가 각 버튼을 누를 때마다 새로 생성되지 않고 1번만 생성되어 한번의 Fragment의 변화를 commit()한 후 다시 다른 화면으로 commit하려할 때 위의 에러가 발생하는 것이었다. **이미 화면을 그리면서  commit()한 transaction에 다른 Fragment를 할당하고 Commit()하려 했기 때문에 이미 commit되었다고 에러가 발생하면서 앱이 꺼지는 것이다.**

=> 따라서, 각 버튼의 `setOnClickListener()`안에 작성하여 버튼이 클릭될 때마다 transaction을 따로 만들어 주어 관리해야 한다. 

<br><br>

-----

### 실행화면 

1. 로그인 화면

<img src = "https://user-images.githubusercontent.com/31370590/136657827-e153f3f9-4507-4a20-8b2e-6e3dd6817979.PNG" width = "250" height = "450">

<br>

2. 아이디와 비밀번호 입력 후 로그인 버튼 클릭 시, `HomeActivity`로 전환 

   <img src = "https://user-images.githubusercontent.com/31370590/138468555-60464603-805a-4ae8-8348-8ac2cd845563.PNG" width = "250" height = "450">

<br>

3. 각 버튼을 누르면 프래그먼트가 전환되고 이에 따라 리사이클러뷰에서 해당하는 data 표시해줌

   <img src = "https://user-images.githubusercontent.com/31370590/138468763-9851b130-cf10-42a6-a701-8c34033e9ec9.PNG" width = "250" height = "450">
