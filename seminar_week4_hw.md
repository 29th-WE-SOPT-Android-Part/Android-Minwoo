# ๐ป Week 4 ๊ณผ์  

## 1๏ธโฃ Level 1 ํ์๊ณผ์ 

-----

### ์ฝ๋ ์ค๋ช

#### ์ ์ฒด์ ์ธ ์ฝ๋ ์ค๋ช

์ธ๋ฏธ๋์์ ๋ฐฐ์ ๋ฏ์ด **๋ก๊ทธ์ธ, ํ์๊ฐ์ ์๋ฒ ํต์ **์ ๊ตฌํํ๊ธฐ ์ํด 

1. **๋ผ์ด๋ธ๋ฌ๋ฆฌ ์ถ๊ฐ ๋ฐ AndroidManifest ์ค์ **
2. **์๋ฒ Request / Response ๊ฐ์ฒด ์ค๊ณ**
3. **Retrofit Interface ์ค๊ณ**
4. **Retrofit Interface ์ค์  ๊ตฌํ์ฒด(๊ฐ์ฒด) ๋ง๋ค๊ธฐ**
5.  **Callback ๋ฑ๋กํ์ฌ ํต์  ์์ฒญ**

์ ๋จ๊ณ๋ฅผ ๊ฑฐ์ณ์ ํด์ฃผ์๋ค. 

<br

<br><br>

#### ํต์ฌ ๊ตฌํ ๋ด์ฉ

์ฐ์ , ํ์๊ฐ์ ๋ฉ์๋์ ๋ก๊ทธ์ธ ๋ฉ์๋ ๋ชจ๋ ๊ตฌํํ๊ธฐ ์ํด ํ์ํ Retrofit interface์ Retrofit ๊ฐ์ฒด๋ฅผ ๊ตฌํํด์ฃผ์๊ณ  ,๊ฐ ๋ฉ์๋์ request body, response body์ ํด๋นํ๋ data Class๋ฅผ ์ ์ํด์ฃผ์๋ค.

##### ํ์๊ฐ์ ๋ฉ์๋

`SignUpActivity.kt`์ ๋คํธ์ํฌ๋ฅผ ์ด๊ธฐํํ๋ ๋ฉ์๋ `initNetwork()`๋ฅผ ์ ์ํด์ฃผ์๊ณ  , ์ฌ๊ธฐ์ ์ฝ๋ฐฑ์ ๋ฑ๋กํด์ data๋ฅผ ์๋ฒ์์ ๋น๋๊ธฐ์ ์ผ๋ก ๋ฐ์์ค๋๋ก ๊ตฌํํ๊ณ  ๊ทธ data์ ์๋ต์ ๋ฐ๋ผ ๋ค๋ฅธ ๊ธฐ๋ฅ์ ํ๋๋ก ๊ตฌํํด์ฃผ์๋ค. 

๊ทธ๋ฆฌ๊ณ  ์ด `initNetwork()` ๋ฉ์๋๋ฅผ `binding.btnSignUp.setOnClickListener`์ ๋ฃ์ด์ค์ผ๋ก์จ ๊ฐ ํ์๊ฐ์ ๋ฒํผ์ ๋๋ ์ ๋,  ์๋ฒ ํต์ ์ด ์ด๋ฃจ์ด์ง๊ฒ ํด์ฃผ์๋ค. 

```kotlin
private fun initNetwork(){ // ๋คํธ์ํฌ๋ฅผ ์ด๊ธฐํํ๋ ํจ์
        val requestSignUpData = RequestSignUpData(
            name = binding.etName.text.toString(),
            email = binding.etId.text.toString(),
            password = binding.etPwd.text.toString()
        )

        // signUp์ ๋ํ call ๊ฐ์ฒด ์ ์ธ
        val callSignUp: Call<ResponseSignUpData> =  ServiceCreator.basicService.postSignUp(requestSignUpData)

        callSignUp.enqueue(object : Callback<ResponseSignUpData> {
            override fun onResponse(
                call: Call<ResponseSignUpData>,
                response: Response<ResponseSignUpData>
            ) {
                if(response.isSuccessful){
                    val data = response.body()?.data
                    Toast.makeText(this@SignUpActivity, "${data?.name}๋ ํ์๊ฐ์์ ์ถํ๋๋ฆฝ๋๋ค!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    val message = response.body()?.message
                    Toast.makeText(this@SignUpActivity, "$message", Toast.LENGTH_SHORT).show()
                    // ๋ ์ค์ผ ์ ์์ง ์์๊น
                }
            }

            override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable){
                Log.e("NetworkTest", "error:$t")
            }
        })
    }
```

<br>

##### ๋ก๊ทธ์ธ ๋ฉ์๋

ํ์๊ฐ์ ๋ฉ์๋์ ๋น์ทํ ๋งฅ๋ฝ์ผ๋ก ๊ตฌํํ๋ค.

<br><br><br>

------

### ๋งํ๋ ์ , ๊นจ๋ฌ์ ์ 

+ ๊ฐ ๋ฉ์๋๋ณ๋ก ๊ฐ์ Retrofit interface์ Retrofit ๊ฐ์ฒด๋ฅผ ์ฌ์ฉํด๋ ๋๋ค.  

<br><br><br>

-----

### ์คํํ๋ฉด 

1. ๋ก๊ทธ์ธ ํ๋ฉด - ๋ฒํผ ํด๋ฆญ ์ 

   <img src="https://user-images.githubusercontent.com/31370590/141498977-1981653d-c75f-4ce6-a790-0c70ef033949.PNG">

<br>

2. ๋ก๊ทธ์ธ ํ๋ฉด - ๋ก๊ทธ์ธ ๋ฒํผ ํด๋ฆญ ํ

   <img src="https://user-images.githubusercontent.com/31370590/141499079-41cd2ffe-3d83-40be-a99f-0c0d77cc3a3a.PNG">

<br>

3. ํ์๊ฐ์ ํ๋ฉด - ํ์๊ฐ์ ๋ฒํผ ํด๋ฆญ ์ 

   <img  src="https://user-images.githubusercontent.com/31370590/141499156-b481f097-f541-40f3-83ee-2a726a5095bd.PNG">
   
   <br>
   
4. ํ์๊ฐ์ ํ๋ฉด - ํ์๊ฐ์ ๋ฒํผ ํด๋ฆญ ํ

   <img src="https://user-images.githubusercontent.com/31370590/141499233-5f9aeb0a-f177-4d2f-a3f4-cb17d014c668.PNG">
