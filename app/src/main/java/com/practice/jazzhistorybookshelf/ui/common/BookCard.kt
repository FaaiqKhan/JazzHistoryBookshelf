package com.practice.jazzhistorybookshelf.ui.common

import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.practice.jazzhistorybookshelf.R
import com.practice.jazzhistorybookshelf.data.DataSource
import com.practice.jazzhistorybookshelf.models.JazzHistoryBook
import com.practice.jazzhistorybookshelf.ui.theme.JazzHistoryBookshelfTheme

@Composable
fun BookCard(jazzHistoryBook: JazzHistoryBook, modifier: Modifier = Modifier) {
    val image = jazzHistoryBook.volumeInfo.imageLinks?.smallThumbnail?.replace("http:", "https:")
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.card_elevation)
        )
    ) {
        ImageViewer(
            image = image,
            modifier = Modifier.height(dimensionResource(id = R.dimen.card_image_height)),
            contentScale = if (image == null) ContentScale.Fit else ContentScale.FillHeight
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BookCardPreview() {
    JazzHistoryBookshelfTheme {
        BookCard(jazzHistoryBook = DataSource.book1)
    }
}