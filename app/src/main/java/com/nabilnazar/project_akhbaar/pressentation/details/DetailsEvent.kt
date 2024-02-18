package com.nabilnazar.project_akhbaar.pressentation.details

import com.nabilnazar.project_akhbaar.domain.model.Article


sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()
    object RemoveSideEffect : DetailsEvent()


}