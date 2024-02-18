package com.nabilnazar.project_akhbaar.pressentation.search

import androidx.paging.PagingData
import com.nabilnazar.project_akhbaar.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)