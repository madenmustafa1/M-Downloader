package com.maden.m_downloader.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp

@Composable
fun DefaultText(text: String, paddingValue: Int? = null, fontWeight: FontWeight? = null) {
    Text(
        text,
        modifier = Modifier.padding((paddingValue ?: 0).dp),
        fontWeight = fontWeight
    )
}