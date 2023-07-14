package com.practice.jazzhistorybookshelf.ui.common

import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
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
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .crossfade(true)
                .data(image)
                .build(),
            contentDescription = stringResource(id = R.string.book_card_image),
            modifier = Modifier.height(dimensionResource(id = R.dimen.card_image_height)),
            error = painterResource(id = R.drawable.ic_broken_image),
            placeholder = painterResource(id = R.drawable.loading_img),
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