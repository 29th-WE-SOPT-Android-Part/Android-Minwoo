# 💻 Week 4 과제 

## 1️⃣ Level 1 필수과제

-----

### 코드 설명

#### 전체적인 코드 설명



로그인 회원가입 서버 통신

POSTMAN 테스트 + 회원가입 완료 + 로그인 완료 이미지를 

retrofit interface와 구현체, Request/Response 객체에 대한 코드 필수

유저 조회(+Email로 유저 조회), 유서 수정, 유저 삭제 구현은 자유 !

<br><br>

회원가입

+ 회원가입 버튼을 눌렀을 때, 그리고 다 비어있지 않을때 initNetwork 해줘야 하나
+ 그리고 여기서 서버통신을 성공해야 다시 SignActivity로 이동하는 finish()를 호출해줘야 하나
+ 

로그인







각 메서드 별로 인터페이스, object 따로 구현 해야 되나 	

<br><br>

#### 핵심 구현 내용

1. 회원가입 메서드

| 메소드 | 경로         | 짧은 설명                                     |
| ------ | ------------ | --------------------------------------------- |
| POST   | /user/signup | 사용자가 입력한 정보로 회원가입을 진행합니다. |

## 요청 헤더

```
Content-Type: application/json
```

## 요청 바디

| key      | 설명            | 타입   |
| -------- | --------------- | ------ |
| email    | 사용자 이메일   | String |
| name     | 사용자 이름     | String |
| password | 사용자 비밀번호 | String |

```
{
    "email": "kimwy1997@gmail.com",
    "name": "우영",
    "password": 123456
}
```

## 응답 바디

### 성공

```
{
    "status": 200,
    "success": true,
    "message": "회원 가입 성공",
    "data": {
        "id": 4,
        "name": "우영",
        "password": 123456,
        "email": "kimwy1997@gmail.com"
    }
}
```

### 실패

- 입력값에 NULL VALUE

```
{
    "status": 400,
    "success": false,
    "message": "필요한 값이 없습니다"
}
```

- 이메일 중복

```
{
    "status": 400,
    "success": false,
    "message": "이미 사용중인 이메일입니다."
}
```

- 서버 내부 에러

```
{
    "status": 500,
    "success": false,
    "message": "서버 내부 에러"
}
```







<br>

#### 기타 구현 내용



<br><br>

------

### 막혔던 점, 깨달은 점



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
