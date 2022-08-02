package com.maden.m_downloader.model

data class DownloadVideoData(
    val progress: Float,
    val etaInSeconds: Long,
    val line: String,
    val currentState: DownloadState
)