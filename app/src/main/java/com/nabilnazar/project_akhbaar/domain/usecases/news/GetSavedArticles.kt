package com.nabilnazar.project_akhbaar.domain.usecases.news

import com.nabilnazar.project_akhbaar.data.local.NewsDao
import com.nabilnazar.project_akhbaar.domain.model.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedArticles @Inject constructor(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>>{
        return newsDao.getArticles()
    }

}