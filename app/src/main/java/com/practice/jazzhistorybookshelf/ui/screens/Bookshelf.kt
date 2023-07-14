package com.practice.jazzhistorybookshelf.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.practice.jazzhistorybookshelf.R
import com.practice.jazzhistorybookshelf.data.DataSource
import com.practice.jazzhistorybookshelf.models.JazzHistoryBook
import com.practice.jazzhistorybookshelf.ui.common.*
import com.practice.jazzhistorybookshelf.ui.screens.errorScreen.ErrorScreen
import com.practice.jazzhistorybookshelf.ui.screens.loadingScreen.LoadingScreen
import com.practice.jazzhistorybookshelf.ui.states.BookUiState
import com.practice.jazzhistorybookshelf.ui.theme.JazzHistoryBookshelfTheme

@Composable
fun Bookshelf(
    modifier: Modifier = Modifier,
    books: List<JazzHistoryBook>,
    onClick: (id: String) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = dimensionResource(id = R.dimen.grid_cell)),
        contentPadding = PaddingValues(all = dimensionResource(id = R.dimen.list_content_padding)),
        verticalArrangement = Arrangement.spacedBy(
            space = dimensionResource(id = R.dimen.list_content_padding)
        ),
        horizontalArrangement = Arrangement.spacedBy(
            space = dimensionResource(id = R.dimen.list_content_padding)
        )
    ) {
        items(items = books, key = { book -> book.id }) {
            BookCard(jazzHistoryBook = it, onClick = onClick)
        }
    }
}

@Composable
fun BookshelfMedium(
    modifier: Modifier = Modifier,
    books: List<JazzHistoryBook>,
    onClick: (id: String) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(all = dimensionResource(id = R.dimen.list_content_padding)),
        verticalArrangement = Arrangement.spacedBy(
            space = dimensionResource(id = R.dimen.list_content_padding)
        ),
        horizontalArrangement = Arrangement.spacedBy(
            space = dimensionResource(id = R.dimen.list_content_padding)
        )
    ) {
        items(items = books, key = { book -> book.id }) {
            BookCardDetails(jazzHistoryBook = it, onClick = onClick)
        }
    }
}

@Composable
fun BookshelfExpanded(
    modifier: Modifier = Modifier,
    books: List<JazzHistoryBook>,
    bookUIState: BookUiState,
    onClick: (id: String) -> Unit,
) {
    Row(modifier = modifier) {
        LazyVerticalGrid(
            modifier = Modifier.weight(1.5f),
            columns = GridCells.Fixed(1),
            contentPadding = PaddingValues(all = dimensionResource(id = R.dimen.list_content_padding)),
            verticalArrangement = Arrangement.spacedBy(
                space = dimensionResource(id = R.dimen.list_content_padding)
            ),
            horizontalArrangement = Arrangement.spacedBy(
                space = dimensionResource(id = R.dimen.list_content_padding)
            )
        ) {
            items(items = books, key = { book -> book.id }) {
                BookCardDetails(
                    jazzHistoryBook = it,
                    onClick = onClick
                )
            }
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(dimensionResource(id = R.dimen.list_content_padding))
        ) {
            when (bookUIState) {
                is BookUiState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
                is BookUiState.Success -> BookDetails(bookUiState = bookUIState)
                is BookUiState.Error -> ErrorScreen(
                    retryAction = { },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BookshelfPreview() {
    JazzHistoryBookshelfTheme {
        Bookshelf(books = DataSource.books) {}
    }
}

@Preview(name = "Light theme", showBackground = true, widthDp = 1000, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark theme", showBackground = true, widthDp = 1000, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun BookshelfExpandedPreview() {
    JazzHistoryBookshelfTheme {
        BookshelfExpanded(
            books = DataSource.books,
            bookUIState = BookUiState.Success(DataSource.book1)
        ) {}
    }
}