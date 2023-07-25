package com.practice.jazzhistorybookshelf.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.practice.jazzhistorybookshelf.R
import com.practice.jazzhistorybookshelf.ui.screens.errorScreen.ErrorScreen
import com.practice.jazzhistorybookshelf.ui.screens.loadingScreen.LoadingScreen
import com.practice.jazzhistorybookshelf.ui.states.BookUiState
import com.practice.jazzhistorybookshelf.utils.Utils

@Composable
fun BookDetails(modifier: Modifier = Modifier, bookUiState: BookUiState) {
    when (bookUiState) {
        is BookUiState.Loading -> LoadingScreen()
        is BookUiState.Success -> {
            Column(
                modifier = modifier.verticalScroll(rememberScrollState())
            ) {
                Row {
                    ImageViewer(
                        image = Utils.createImageUrl(bookUiState.book.volumeInfo.imageLinks?.thumbnail),
                        modifier = Modifier
                            .height(dimensionResource(id = R.dimen.card_image_height))
                            .width(dimensionResource(id = R.dimen.card_small_image_width))
                    )
                    Column(
                        modifier = Modifier.padding(start = dimensionResource(id = R.dimen.list_content_padding))
                    ) {
                        MultiStyleText(
                            text1 = "Title: ",
                            text2 = bookUiState.book.volumeInfo.title
                        )
                        MultiStyleText(
                            text1 = "Author(s): ",
                            text2 = bookUiState.book.volumeInfo.authors?.first()
                        )
                        MultiStyleText(
                            text1 = "Pages: ",
                            text2 = bookUiState.book.volumeInfo.pageCount.toString()
                        )
                        MultiStyleText(
                            text1 = "Publisher: ",
                            text2 = bookUiState.book.volumeInfo.publisher
                        )
                        MultiStyleText(
                            text1 = "Published date: ",
                            text2 = bookUiState.book.volumeInfo.publishedDate
                        )
                        MultiStyleText(
                            text1 = "Language: ",
                            text2 = bookUiState.book.volumeInfo.language
                        )
                    }
                }
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.list_content_padding)))
                Text(text = "Description ", style = MaterialTheme.typography.bodyLarge)
                Text(
                    text = bookUiState.book.volumeInfo.description ?: "",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.list_content_padding)))
                Text(text = "SaleInfo", style = MaterialTheme.typography.bodyLarge)
                MultiStyleText(
                    text1 = "Country: ",
                    text2 = bookUiState.book.saleInfo?.country
                )
                MultiStyleText(
                    text1 = "Saleability: ",
                    text2 = bookUiState.book.saleInfo?.saleability
                )
                MultiStyleText(
                    text1 = "Ebook available: ",
                    text2 = (if (bookUiState.book.saleInfo?.isEbook == true) "Yes" else "No")
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.list_content_padding)))
                Text(text = "AccessInfo", style = MaterialTheme.typography.bodyLarge)
                MultiStyleText(
                    text1 = "Public domain: ",
                    text2 = (if (bookUiState.book.accessInfo?.publicDomain == true) "Yes" else "No")
                )
                MultiStyleText(
                    text1 = "Text to speed permission: ",
                    text2 = bookUiState.book.accessInfo?.textToSpeechPermission
                )
                MultiStyleText(
                    text1 = "PDF available: ",
                    text2 = bookUiState.book.accessInfo?.pdf?.isAvailable.toString()
                )
                MultiStyleText(
                    text1 = "Quote sharing allowed: ",
                    text2 = (if (bookUiState.book.accessInfo?.quoteSharingAllowed == true) "Yes" else "No")
                )
            }
        }

        is BookUiState.Error -> ErrorScreen(retryAction = { })
    }
}