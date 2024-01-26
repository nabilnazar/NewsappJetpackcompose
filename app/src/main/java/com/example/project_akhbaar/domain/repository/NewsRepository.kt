package com.example.project_akhbaar.domain.repository

import kotlinx.coroutines.flow.Flow
import androidx.paging.PagingData
import com.example.project_akhbaar.domain.model.Article

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>
    fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>
}