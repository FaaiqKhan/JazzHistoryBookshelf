package com.practice.jazzhistorybookshelf.ui.screens.homeScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.practice.jazzhistorybookshelf.ui.screens.*
import com.practice.jazzhistorybookshelf.ui.screens.errorScreen.ErrorScreen
import com.practice.jazzhistorybookshelf.ui.screens.loadingScreen.LoadingScreen
import com.practice.jazzhistorybookshelf.ui.states.JazzHistoryBookUiState

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeScreenViewModel = viewModel(),
    windowWidthSize: WindowWidthSizeClass
) {
    when (homeViewModel.uiState) {
        is JazzHistoryBookUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is JazzHistoryBookUiState.Success -> {
            when (windowWidthSize) {
                WindowWidthSizeClass.Expanded -> {
                    val bookState by homeViewModel.bookUiState.collectAsState()
                    BookshelfExpanded(
                        modifier = modifier.fillMaxWidth(),
                        books = (homeViewModel.uiState as JazzHistoryBookUiState.Success).books,
                        bookUIState = bookState,
                        onClick = { homeViewModel.selectBook(it) },
                    )
                }

                WindowWidthSizeClass.Medium -> {
                    BookshelfMedium(
                        books = (homeViewModel.uiState as JazzHistoryBookUiState.Success).books,
                        modifier = modifier.fillMaxWidth()
                    )
                }

                else -> {
                    Bookshelf(
                        books = (homeViewModel.uiState as JazzHistoryBookUiState.Success).books,
                        modifier = modifier.fillMaxWidth(),
                        onClick = {
                            homeViewModel.selectBook(it)
                        }
                    )
                }
            }
        }

        is JazzHistoryBookUiState.Error -> ErrorScreen(
            retryAction = homeViewModel::getJazzHistory,
            modifier = modifier.fillMaxSize()
        )
    }
}