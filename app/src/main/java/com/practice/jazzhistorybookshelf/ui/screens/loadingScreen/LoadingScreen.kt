package com.practice.jazzhistorybookshelf.ui.screens.loadingScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practice.jazzhistorybookshelf.R
import com.practice.jazzhistorybookshelf.ui.theme.JazzHistoryBookshelfTheme

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(id = R.drawable.loading_img),
        contentDescription = stringResource(id = R.string.loading)
    )
}

@Preview(showBackground = true)
@Composable
private fun LoadingScreenPreview() {
    JazzHistoryBookshelfTheme {
        LoadingScreen()
    }
}