package com.example.chinkuanlin_newsapi

data class Article(
    //val date: String,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String,
    val viewType: Int
)
