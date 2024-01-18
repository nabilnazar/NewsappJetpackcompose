package com.example.project_akhbaar.data.network.dto

import com.example.project_akhbaar.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)