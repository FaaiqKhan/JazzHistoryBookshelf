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
    onClick: (id: String) -> Unit
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
        onClick = { onClick(jazzHistoryBook.id) }
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
                MultiStyleText(
                    text1 = "Title: ",
                    text2 = jazzHistoryBook.volumeInfo.title ?: notAvailableText
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.list_content_padding)))
                MultiStyleText(
                    text1 = "Author(s): ",
                    text2 = jazzHistoryBook.volumeInfo.authors?.first() ?: notAvailableText
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.list_content_padding)))
                MultiStyleText(
                    text1 = "Description: ",
                    text2 = jazzHistoryBook.volumeInfo.description ?: notAvailableText,
                    overflow = TextOverflow.Ellipsis
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