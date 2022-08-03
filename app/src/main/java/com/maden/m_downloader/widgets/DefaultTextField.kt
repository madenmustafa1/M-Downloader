package com.maden.m_downloader.widgets

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maden.m_downloader.view.download_activity.DownloadVideoViewModel

@Composable
fun DefaultTextField(
    listener: (value: String) -> Unit,
    viewModel: DownloadVideoViewModel = viewModel()
) {

}