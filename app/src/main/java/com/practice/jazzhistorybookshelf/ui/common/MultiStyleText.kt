package com.practice.jazzhistorybookshelf.ui.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun MultiStyleText(text1: String, text2: String?, overflow: TextOverflow = TextOverflow.Clip) {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    fontWeight = MaterialTheme.typography.bodyLarge.fontWeight
                )
            ) {
                append(text1)
            }
            withStyle(
                style = SpanStyle(
                    fontStyle = MaterialTheme.typography.bodyMedium.fontStyle,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                )
            ) {
                append(text2)
            }
        }, overflow = overflow
    )
}