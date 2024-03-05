package com.example.chinkuanlin_newsapi

import retrofit2.http.GET
import retrofit2.http.Query
import com.example.chinkuanlin_newsapi.Constants.Companion.API_KEY
import retrofit2.Call
import java.util.Locale.IsoCountryCode

interface NewsAPI {
    @GET("v2/top-headlines")
    fun getHeadlines(
        @Query("country") countryCode: String = "us",
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    ): Call<NewsResponse>

    @GET("v2/top-headlines")
    fun getBusiness(
        @Query("country") countryCode: String = "us",
        @Query("page") pageNumber: Int = 1,
        @Query("category") category: String = "business",
        @Query("apiKey") apiKey: String = API_KEY
    ): Call<NewsResponse>

    @GET("v2/top-headlines")
    fun getSports(
        @Query("country") countryCode: String = "us",
        @Query("page") pageNumber: Int = 1,
        @Query("category") category: String = "sports",
        @Query("apiKey") apiKey: String = API_KEY
    ): Call<NewsResponse>
}