package com.practice.jazzhistorybookshelf.ui.screens.homeScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.practice.jazzhistorybookshelf.data.network.JazzHistoryBookResponse
import com.practice.jazzhistorybookshelf.ui.screens.*
import com.practice.jazzhistorybookshelf.ui.screens.errorScreen.ErrorScreen
import com.practice.jazzhistorybookshelf.ui.screens.loadingScreen.LoadingScreen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeScreenViewModel = viewModel(),
    windowWidthSize: WindowWidthSizeClass
) {
    when (homeViewModel.uiState) {
        is JazzHistoryBookResponse.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is JazzHistoryBookResponse.Success -> {
            when (windowWidthSize) {
                WindowWidthSizeClass.Expanded -> {
                    BookshelfExpanded(
                        books = (homeViewModel.uiState as JazzHistoryBookResponse.Success).books,
                        modifier = modifier.fillMaxWidth()
                    )
                }

                WindowWidthSizeClass.Medium -> {
                    BookshelfMedium(
                        books = (homeViewModel.uiState as JazzHistoryBookResponse.Success).books,
                        modifier = modifier.fillMaxWidth()
                    )
                }

                else -> {
                    Bookshelf(
                        books = (homeViewModel.uiState as JazzHistoryBookResponse.Success).books,
                        modifier = modifier.fillMaxWidth()
                    )
                }
            }
        }

        is JazzHistoryBookResponse.Error -> ErrorScreen(
            retryAction = homeViewModel::getJazzHistory,
            modifier = modifier.fillMaxSize()
        )
    }
}