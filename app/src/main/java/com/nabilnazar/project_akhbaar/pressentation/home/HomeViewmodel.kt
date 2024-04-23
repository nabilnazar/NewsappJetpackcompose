package com.nabilnazar.project_akhbaar.pressentation.home


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.nabilnazar.project_akhbaar.domain.repository.NewsRepository
import com.nabilnazar.project_akhbaar.domain.usecases.news.GetNews
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNewsUseCase: GetNews,
    private val newsRepository: NewsRepository
): ViewModel() {
    private val selectedSources: List<String> = newsRepository.getSelectedSources()
    var state = mutableStateOf(HomeState())
        private set

    val news = getNewsUseCase(
        sources = selectedSources
    ).cachedIn(viewModelScope)

    fun onEvent(event: HomeEvent){
        when(event){
            is HomeEvent.UpdateScrollValue -> updateScrollValue(event.newValue)
            is HomeEvent.UpdateMaxScrollingValue -> updateMaxScrollingValue(event.newValue)
        }
    }

    private fun updateScrollValue(newValue: Int){
        state.value = state.value.copy(scrollValue = newValue)
    }
    private fun updateMaxScrollingValue(newValue: Int){
        state.value = state.value.copy(maxScrollingValue = newValue)
    }

}