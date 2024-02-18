package com.nabilnazar.project_akhbaar.domain.repository

import kotlinx.coroutines.flow.Flow
import androidx.paging.PagingData
import com.nabilnazar.project_akhbaar.domain.model.Article

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>

    fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>

    suspend fun upsertArticle(article: Article)

    suspend fun deleteArticle(article: Article)

    fun getArticles(): Flow<List<Article>>

    suspend fun getArticle(url: String): Article?

}