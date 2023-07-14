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
import com.practice.jazzhistorybookshelf.utils.Utils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookCard(
    modifier: Modifier = Modifier,
    jazzHistoryBook: JazzHistoryBook,
    onClick: (id: String) -> Unit
) {
    val image = Utils.createImageUrl(jazzHistoryBook.volumeInfo.imageLinks?.smallThumbnail)
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.card_elevation)
        ),
        onClick = { onClick(jazzHistoryBook.id) }
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
        BookCard(jazzHistoryBook = DataSource.book1) {}
    }
}