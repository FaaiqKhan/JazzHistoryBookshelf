package com.practice.jazzhistorybookshelf.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
                        modifier = Modifier.padding(
                            start = dimensionResource(id = R.dimen.list_content_padding)
                        )
                    ) {
                        Text(text = "Title: " + bookUiState.book.volumeInfo.title)
                        Text(text = "Author(s): " + bookUiState.book.volumeInfo.authors?.first())
                        Text(text = "Pages: " + bookUiState.book.volumeInfo.pageCount)
                        Text(text = "Publisher: " + bookUiState.book.volumeInfo.publisher)
                        Text(text = "Published date: " + bookUiState.book.volumeInfo.publishedDate)
                        Text(text = "Language: " + bookUiState.book.volumeInfo.language)
                    }
                }
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.list_content_padding)))
                Text(text = "Description: " + bookUiState.book.volumeInfo.description)
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.list_content_padding)))
                Text(text = "SaleInfo")
                Text(text = "Country: " + bookUiState.book.saleInfo?.country)
                Text(text = "Saleability: " + bookUiState.book.saleInfo?.saleability)
                Text(text = "Ebook available: " + (if (bookUiState.book.saleInfo?.isEbook == true) "Yes" else "No"))
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.list_content_padding)))
                Text(text = "AccessInfo")
                Text(text = "Public domain: " + (if (bookUiState.book.accessInfo?.publicDomain == true) "Yes" else "No"))
                Text(text = "Text to speed permission: " + bookUiState.book.accessInfo?.textToSpeechPermission)
                Text(text = "PDF available: " + bookUiState.book.accessInfo?.pdf?.isAvailable)
                Text(text = "Quote sharing allowed: " + (if (bookUiState.book.accessInfo?.quoteSharingAllowed == true) "Yes" else "No"))
            }
        }

        is BookUiState.Error -> ErrorScreen(retryAction = { })
    }
}