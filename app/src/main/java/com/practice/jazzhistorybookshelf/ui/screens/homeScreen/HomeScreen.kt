package com.practice.jazzhistorybookshelf.ui.screens.homeScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.practice.jazzhistorybookshelf.states.JazzHistoryBookUiState
import com.practice.jazzhistorybookshelf.ui.screens.Bookshelf
import com.practice.jazzhistorybookshelf.ui.screens.errorScreen.ErrorScreen
import com.practice.jazzhistorybookshelf.ui.screens.loadingScreen.LoadingScreen

@Composable
fun HomeScreen(uiState: JazzHistoryBookUiState, modifier: Modifier = Modifier) {
    when (uiState) {
        is JazzHistoryBookUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is JazzHistoryBookUiState.Success -> Bookshelf()
        is JazzHistoryBookUiState.Error -> ErrorScreen(
            retryAction = {},
            modifier = modifier.fillMaxSize()
        )
    }
}