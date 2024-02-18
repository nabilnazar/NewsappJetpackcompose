package com.nabilnazar.project_akhbaar.data.network.dto

import com.nabilnazar.project_akhbaar.domain.model.CategoryNewsSource

data class NewsCategoryResponse(
    val sources: List<CategoryNewsSource>,
    val status: String
)