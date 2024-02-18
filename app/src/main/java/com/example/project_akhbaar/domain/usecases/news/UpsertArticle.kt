package com.example.project_akhbaar.domain.usecases.news

import com.example.project_akhbaar.data.local.NewsDao
import com.example.project_akhbaar.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.upsert(article = article)
    }

}