package com.practice.jazzhistorybookshelf.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.practice.jazzhistorybookshelf.R
import com.practice.jazzhistorybookshelf.data.DataSource
import com.practice.jazzhistorybookshelf.models.JazzHistoryBook
import com.practice.jazzhistorybookshelf.ui.common.BookCard
import com.practice.jazzhistorybookshelf.ui.theme.JazzHistoryBookshelfTheme

@Composable
fun Bookshelf(books: List<JazzHistoryBook>, modifier: Modifier = Modifier) {
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
            BookCard(jazzHistoryBook = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BookshelfPreview() {
    JazzHistoryBookshelfTheme {
        Bookshelf(books = DataSource.books)
    }
}