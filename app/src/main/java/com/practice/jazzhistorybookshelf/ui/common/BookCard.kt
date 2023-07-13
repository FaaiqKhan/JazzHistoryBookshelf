package com.practice.jazzhistorybookshelf.ui.common

import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.*
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.practice.jazzhistorybookshelf.R
import com.practice.jazzhistorybookshelf.models.JazzHistoryBook

@Composable
fun BookCard(jazzHistoryBook: JazzHistoryBook, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.card_elevation)
        )
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(jazzHistoryBook.volumeInfo.imageLinks.smallThumbnail)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(id = R.string.book_card_image),
            modifier = Modifier.height(dimensionResource(id = R.dimen.card_image_height)),
            error = painterResource(id = R.drawable.ic_broken_image),
            placeholder = painterResource(id = R.drawable.loading_img)
        )
    }
}