package com.example.project_akhbaar.pressentation.details.components


sealed class DetailsEvent {

    object UpsertDeleteArticle : DetailsEvent()
    object RemoveSideEffect : DetailsEvent()


}