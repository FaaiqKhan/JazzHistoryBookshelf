package com.practice.jazzhistorybookshelf.ui.common

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.practice.jazzhistorybookshelf.R
import com.practice.jazzhistorybookshelf.data.DataSource
import com.practice.jazzhistorybookshelf.models.JazzHistoryBook
import com.practice.jazzhistorybookshelf.ui.theme.JazzHistoryBookshelfTheme
import com.practice.jazzhistorybookshelf.utils.Utils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookCardDetails(
    modifier: Modifier = Modifier,
    jazzHistoryBook: JazzHistoryBook,
    onClick: (selectedBook: JazzHistoryBook) -> Unit
) {
    val notAvailableText = "Not available"
    val image = Utils.createImageUrl(jazzHistoryBook.volumeInfo.imageLinks?.smallThumbnail)
    Card(
        modifier = modifier
            .height(dimensionResource(id = R.dimen.card_height))
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.card_elevation)
        ),
        onClick = { onClick(jazzHistoryBook) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ImageViewer(
                image = image,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(dimensionResource(id = R.dimen.card_small_image_width))
            )
            Column(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.list_content_padding)),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Title: " + (jazzHistoryBook.volumeInfo.title ?: notAvailableText),
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.list_content_padding)))
                Text(
                    text = "Author(s): " + (jazzHistoryBook.volumeInfo.authors?.first()
                        ?: notAvailableText),
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.list_content_padding)))
                Text(
                    text = "Description: " + (jazzHistoryBook.volumeInfo.description
                        ?: notAvailableText),
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(name = "Light theme", showBackground = true, widthDp = 700, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark theme", showBackground = true, widthDp = 700, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun BookCardDetails() {
    JazzHistoryBookshelfTheme {
        BookCardDetails(jazzHistoryBook = DataSource.book1) { }
    }
}