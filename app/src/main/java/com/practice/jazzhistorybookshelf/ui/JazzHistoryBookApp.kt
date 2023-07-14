package com.practice.jazzhistorybookshelf.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.practice.jazzhistorybookshelf.R
import com.practice.jazzhistorybookshelf.ui.screens.homeScreen.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JazzHistoryBookApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { JazzHistoryBookAppTopBar() }
    ) {
        HomeScreen(modifier = modifier.padding(it))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JazzHistoryBookAppTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(id = R.string.bookshelf),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}