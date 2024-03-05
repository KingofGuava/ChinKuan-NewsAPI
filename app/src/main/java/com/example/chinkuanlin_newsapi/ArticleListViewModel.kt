package com.example.chinkuanlin_newsapi

import android.util.Log
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.MutableLiveData
class ArticleListViewModel : ViewModel() {
    val articles: MutableLiveData<List<Article>> = MutableLiveData()

    fun fetchTopHeadlines(apiKey: String) {
        RetrofitInstance.api.getHeadlines("us", 1, apiKey).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    articles.postValue(response.body()?.articles)

                } else {
                    Log.e("API_ERROR", "Failed to fetch articles: ${response.errorBody()?.string()}")
                }
            }
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("API_ERROR", "Call failed with message: ${t.message}")
            }
        })
    }

    fun fetchBusiness(apiKey: String) {
        RetrofitInstance.api.getBusiness("us", 1, "business", apiKey).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    articles.postValue(response.body()?.articles)
                } else {
                    Log.e("API_ERROR", "Failed to fetch articles: ${response.errorBody()?.string()}")
                }
            }
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("API_ERROR", "Call failed with message: ${t.message}")
            }
        })
    }

    fun fetchSports(apiKey: String) {
        RetrofitInstance.api.getBusiness("us", 1, "sports", apiKey).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    articles.postValue(response.body()?.articles)
                } else {
                    Log.e("API_ERROR", "Failed to fetch articles: ${response.errorBody()?.string()}")
                }
            }
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("API_ERROR", "Call failed with message: ${t.message}")
            }
        })
    }
}