package com.practice.jazzhistorybookshelf.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
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
import com.practice.jazzhistorybookshelf.utils.Utils

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
fun BookshelfMedium(modifier: Modifier = Modifier, books: List<JazzHistoryBook>) {
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
            BookCardDetails(jazzHistoryBook = it, onClick = { })
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
                is BookUiState.Success -> BookDetails(book = bookUIState.book)
                is BookUiState.Error -> ErrorScreen(
                    retryAction = { },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun BookDetails(book: JazzHistoryBook) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Row {
            ImageViewer(
                image = Utils.createImageUrl(book.volumeInfo.imageLinks?.thumbnail),
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.card_image_height))
                    .width(dimensionResource(id = R.dimen.card_small_image_width))
            )
            Column(
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.list_content_padding)
                )
            ) {
                Text(text = "Title: " + book.volumeInfo.title)
                Text(text = "Author(s): " + book.volumeInfo.authors?.first())
                Text(text = "Pages: " + book.volumeInfo.pageCount)
                Text(text = "Publisher: " + book.volumeInfo.publisher)
                Text(text = "Published date: " + book.volumeInfo.publishedDate)
                Text(text = "Language: " + book.volumeInfo.language)
            }
        }
        Text(text = "Description: " + book.volumeInfo.description)
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
        BookshelfExpanded(books = DataSource.books, bookUIState = BookUiState.Loading) {}
    }
}