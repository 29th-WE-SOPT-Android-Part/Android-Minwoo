package com.example.week1.data.remote

data class ResponseSignUpData(
    val status : Int,
    val success : String,
    val message : String,
    val data : Data
) {
    data class Data(
        val id : Int,
        val name : String,
        val password : String,
        val email : String
    )
}
