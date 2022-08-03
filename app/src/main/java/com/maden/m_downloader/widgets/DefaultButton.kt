package com.maden.m_downloader.widgets

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun DefaultButton(
    text: String,
    paddingValue: Int? = null,
    fontWeight: FontWeight? = null,
    listener: () -> Unit
) {
    Button(onClick = { listener() }) {
        DefaultText(
            text = text,
            paddingValue = paddingValue,
            fontWeight = fontWeight
        )
    }
}