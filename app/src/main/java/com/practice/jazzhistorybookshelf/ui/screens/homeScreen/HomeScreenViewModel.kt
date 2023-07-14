package com.practice.jazzhistorybookshelf.ui.screens.homeScreen

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.jazzhistorybookshelf.data.repository.JazzHistoryBookRepository
import com.practice.jazzhistorybookshelf.ui.states.BookUiState
import com.practice.jazzhistorybookshelf.ui.states.JazzHistoryBookUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repository: JazzHistoryBookRepository) :
    ViewModel() {

    var uiState: JazzHistoryBookUiState by mutableStateOf(JazzHistoryBookUiState.Loading)
        private set

    private val _bookUiState = MutableStateFlow<BookUiState>(BookUiState.Loading)
    val bookUiState: StateFlow<BookUiState> get() = _bookUiState

    init {
        getJazzHistory()
    }

    fun getJazzHistory() {
        viewModelScope.launch {
            uiState = try {
                val result = repository.getJazzHistoryBooks()
                _bookUiState.emit(BookUiState.Success(result.first()))
                JazzHistoryBookUiState.Success(books = result)
            } catch (e: IOException) {
                JazzHistoryBookUiState.Error
            }
        }
    }

    fun selectBook(id: String) {
        viewModelScope.launch {
            _bookUiState.emit(BookUiState.Loading)
            _bookUiState.emit(
                try {
                    BookUiState.Success(repository.getJazzHistoryBook(id))
                } catch (e: IOException) {
                    BookUiState.Error
                }
            )
        }
    }
}