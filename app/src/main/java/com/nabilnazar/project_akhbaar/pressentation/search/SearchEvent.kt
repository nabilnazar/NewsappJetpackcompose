package com.nabilnazar.project_akhbaar.pressentation.search

sealed class SearchEvent {

    data class UpdateSearchQuery(val searchQuery: String) : SearchEvent()

    object SearchNews : SearchEvent()
}