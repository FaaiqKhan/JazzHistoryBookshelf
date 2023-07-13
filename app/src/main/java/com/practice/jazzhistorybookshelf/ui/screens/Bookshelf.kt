package com.practice.jazzhistorybookshelf.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.practice.jazzhistorybookshelf.ui.theme.JazzHistoryBookshelfTheme

@Composable
fun Bookshelf(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
private fun BookshelfPreview() {
    JazzHistoryBookshelfTheme {
        Bookshelf()
    }
}