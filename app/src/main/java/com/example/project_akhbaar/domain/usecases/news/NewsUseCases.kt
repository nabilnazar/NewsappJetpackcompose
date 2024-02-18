package com.example.project_akhbaar.domain.usecases.news


data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val deleteArticle: DeleteArticle,
    val getArticles: GetArticles,
    val upsertArticle: UpsertArticle
)