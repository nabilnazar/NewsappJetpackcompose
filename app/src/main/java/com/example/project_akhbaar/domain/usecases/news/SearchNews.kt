package com.example.project_akhbaar.domain.usecases.news

import androidx.paging.PagingData
import com.example.project_akhbaar.domain.model.Article
import com.example.project_akhbaar.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(
            searchQuery = searchQuery,
            sources = sources
        )
    }
}