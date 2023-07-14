package com.practice.jazzhistorybookshelf.ui.screens.homeScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.practice.jazzhistorybookshelf.ui.states.JazzHistoryBookUiState
import com.practice.jazzhistorybookshelf.ui.screens.Bookshelf
import com.practice.jazzhistorybookshelf.ui.screens.errorScreen.ErrorScreen
import com.practice.jazzhistorybookshelf.ui.screens.loadingScreen.LoadingScreen

@Composable
fun HomeScreen(modifier: Modifier = Modifier, homeViewModel: HomeScreenViewModel = viewModel()) {
    when (homeViewModel.uiState) {
        is JazzHistoryBookUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is JazzHistoryBookUiState.Success -> Bookshelf(
            books = (homeViewModel.uiState as JazzHistoryBookUiState.Success).books,
            modifier = modifier.fillMaxWidth()
        )

        is JazzHistoryBookUiState.Error -> ErrorScreen(
            retryAction = homeViewModel::getJazzHistory,
            modifier = modifier.fillMaxSize()
        )
    }
}