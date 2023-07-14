package com.practice.jazzhistorybookshelf.ui.screens.homeScreen

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.jazzhistorybookshelf.data.repository.JazzHistoryBookRepository
import com.practice.jazzhistorybookshelf.ui.states.JazzHistoryBookUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repository: JazzHistoryBookRepository) :
    ViewModel() {

    var uiState: JazzHistoryBookUiState by mutableStateOf(JazzHistoryBookUiState.Loading)
        private set

    init {
        getJazzHistory()
    }

    fun getJazzHistory() {
        viewModelScope.launch {
            uiState = try {
                JazzHistoryBookUiState.Success(books = repository.getJazzHistoryBooks())
            } catch (e: IOException) {
                JazzHistoryBookUiState.Error
            }
        }
    }
}