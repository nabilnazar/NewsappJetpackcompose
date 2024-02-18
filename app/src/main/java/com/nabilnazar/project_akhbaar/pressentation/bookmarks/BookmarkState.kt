package com.nabilnazar.project_akhbaar.pressentation.bookmarks

import com.nabilnazar.project_akhbaar.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)
