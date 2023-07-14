package com.practice.jazzhistorybookshelf.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.practice.jazzhistorybookshelf.R

@Composable
fun ImageViewer(
    modifier: Modifier = Modifier,
    image: Any?,
    contentScale: ContentScale = ContentScale.Fit
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .crossfade(true)
            .data(image)
            .build(),
        contentDescription = stringResource(id = R.string.book_card_image),
        modifier = modifier,
        error = painterResource(id = R.drawable.ic_broken_image),
        placeholder = painterResource(id = R.drawable.loading_img),
        alignment = Alignment.CenterStart,
        contentScale = contentScale
    )
}