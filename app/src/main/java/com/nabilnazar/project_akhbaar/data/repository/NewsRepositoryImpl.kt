package com.nabilnazar.project_akhbaar.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nabilnazar.project_akhbaar.data.local.NewsDao
import com.nabilnazar.project_akhbaar.data.network.NewsApi
import com.nabilnazar.project_akhbaar.data.network.NewsPagingSource
import com.nabilnazar.project_akhbaar.data.network.SearchNewsPagingSource
import com.nabilnazar.project_akhbaar.domain.model.Article
import com.nabilnazar.project_akhbaar.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
) : NewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(newsApi = newsApi, sources = sources.joinToString(separator = ","))
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    api = newsApi,
                    searchQuery = searchQuery,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override suspend fun upsertArticle(article: Article) {
       newsDao.upsert(article)
    }

    override suspend fun deleteArticle(article: Article) {
        newsDao.delete(article)
    }

    override fun getArticles(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

    override suspend fun getArticle(url: String): Article? {
        return newsDao.getArticle(url = url)
    }
}