package com.nabilnazar.project_akhbaar.pressentation.onboarding.components

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.nabilnazar.project_akhbaar.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SharedViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel(){


    // Initialize selectedSources from the repository
    var selectedSources = mutableStateListOf<String>().apply {
        newsRepository.getSelectedSources()
    }


    fun addSources(source: String){
        if (!selectedSources.contains(source)) {
            selectedSources.add(source)
            // Update the repository if needed
            newsRepository.setSelectedSources(selectedSources.toList())
        }
    }

    fun removeSource(source: String){
        if (selectedSources.remove(source)) {
            // Update the repository if needed
            newsRepository.setSelectedSources(selectedSources.toList())
        }
    }
}




