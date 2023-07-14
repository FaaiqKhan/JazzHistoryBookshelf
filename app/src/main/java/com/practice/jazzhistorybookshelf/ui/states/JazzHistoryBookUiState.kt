package com.practice.jazzhistorybookshelf.ui.states

import com.practice.jazzhistorybookshelf.models.JazzHistoryBook

interface JazzHistoryBookUiState {
    val selectedBook: JazzHistoryBook
    val books: List<JazzHistoryBook>
}