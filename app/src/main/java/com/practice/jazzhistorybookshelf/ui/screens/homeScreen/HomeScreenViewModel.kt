package com.practice.jazzhistorybookshelf.ui.screens.homeScreen

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.jazzhistorybookshelf.data.network.JazzHistoryBookResponse
import com.practice.jazzhistorybookshelf.data.repository.JazzHistoryBookRepository
import com.practice.jazzhistorybookshelf.models.JazzHistoryBook
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repository: JazzHistoryBookRepository) :
    ViewModel() {

    var uiState: JazzHistoryBookResponse by mutableStateOf(JazzHistoryBookResponse.Loading)
        private set

    init {
        getJazzHistory()
    }

    fun getJazzHistory() {
        viewModelScope.launch {
            uiState = try {
                JazzHistoryBookResponse.Success(books = repository.getJazzHistoryBooks())
            } catch (e: IOException) {
                JazzHistoryBookResponse.Error
            }
        }
    }
}