package com.nabilnazar.project_akhbaar.domain.usecases.news

import com.nabilnazar.project_akhbaar.data.local.NewsDao
import com.nabilnazar.project_akhbaar.domain.model.Article
import javax.inject.Inject

class DeleteArticle @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.delete(article = article)
    }

}