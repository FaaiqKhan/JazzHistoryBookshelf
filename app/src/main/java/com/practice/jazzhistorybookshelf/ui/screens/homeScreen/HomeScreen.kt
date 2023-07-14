package com.practice.jazzhistorybookshelf.ui.screens.homeScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.practice.jazzhistorybookshelf.ui.common.BookDetails
import com.practice.jazzhistorybookshelf.ui.screens.*
import com.practice.jazzhistorybookshelf.ui.screens.errorScreen.ErrorScreen
import com.practice.jazzhistorybookshelf.ui.screens.loadingScreen.LoadingScreen
import com.practice.jazzhistorybookshelf.ui.states.JazzHistoryBookUiState
import com.practice.jazzhistorybookshelf.utils.Screens

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    windowWidthSize: WindowWidthSizeClass,
    homeViewModel: HomeScreenViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = Screens.BOOKSHELF.name) {
        composable(Screens.BOOKSHELF.name) {
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
                                modifier = modifier.fillMaxWidth(),
                                onClick = {
                                    homeViewModel.selectBook(it)
                                    navController.navigate(Screens.BOOK_DETAILS.name)
                                }
                            )
                        }

                        else -> {
                            Bookshelf(
                                books = (homeViewModel.uiState as JazzHistoryBookUiState.Success).books,
                                modifier = modifier.fillMaxWidth(),
                                onClick = {
                                    homeViewModel.selectBook(it)
                                    navController.navigate(Screens.BOOK_DETAILS.name)
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
        composable(Screens.BOOK_DETAILS.name) {
            val bookState by homeViewModel.bookUiState.collectAsState()
            BookDetails(bookUiState = bookState, modifier = modifier)
        }
    }
}