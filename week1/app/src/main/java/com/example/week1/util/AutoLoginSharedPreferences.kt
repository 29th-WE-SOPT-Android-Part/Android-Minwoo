package com.example.week1.util

import android.content.Context
import android.content.SharedPreferences

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


    fun removeAutoLogin(context: Context) = getAutoLoginSharedPreferences(context)
        .edit()
        .remove(AUTO_LOGIN)
        .apply()


    fun clearAutoLogin(context: Context) = getAutoLoginSharedPreferences(context)
        .edit()
        .clear()
        .apply()

}