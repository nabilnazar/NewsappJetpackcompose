package com.example.project_akhbaar.pressentation.bookmarks

import com.example.project_akhbaar.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)
