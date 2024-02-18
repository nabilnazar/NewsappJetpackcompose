package com.example.project_akhbaar.pressentation.bookmarks


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project_akhbaar.domain.usecases.news.NewsUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


class BookmarkViewModel @Inject constructor(
        private val newsUseCases: NewsUseCases
):ViewModel(){

    private val _state = MutableStateFlow(BookmarkState())
    val state: StateFlow<BookmarkState> = _state


   private fun getArticles(){
        newsUseCases.getArticles().onEach{
            _state.value = _state.value.copy(articles = it)
        }.launchIn(viewModelScope)
    }

}