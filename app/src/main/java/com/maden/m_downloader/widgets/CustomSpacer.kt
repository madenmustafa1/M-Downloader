package com.maden.m_downloader.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maden.m_downloader.util.Constants

@Composable
fun CustomSpacer(padding: Int = Constants.mediumPaddingValue) =
    Spacer(modifier = Modifier.padding(vertical = padding.dp))
