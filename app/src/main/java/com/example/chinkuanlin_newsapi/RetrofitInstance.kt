package com.example.chinkuanlin_newsapi

import com.example.chinkuanlin_newsapi.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Here to send network request to an API, we need to use Retrofit Builder class
class RetrofitInstance {
    companion object{
        val api: NewsAPI by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //automatically take care of mapping JSON data to Object
                .build()
                .create(NewsAPI::class.java)
        }
    }
}