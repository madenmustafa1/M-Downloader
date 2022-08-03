package com.maden.m_downloader.view.download_activity

import android.os.Environment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maden.m_downloader.model.DownloadState
import com.maden.m_downloader.model.DownloadVideoData
import com.maden.m_downloader.util.Constants
import com.yausername.youtubedl_android.YoutubeDL
import com.yausername.youtubedl_android.YoutubeDLRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File
import java.lang.Exception

class DownloadVideoViewModel: ViewModel() {

    private val downloadVideoDataML = MutableLiveData<DownloadVideoData>()
    val downloadVideoLiveData: LiveData<DownloadVideoData> = downloadVideoDataML

    suspend fun downloadVideo(url: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val youtubeDLDir = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    Constants.youtubeChildFieldName
                )

                val request = YoutubeDLRequest(url)
                request.addOption(
                    "-o",
                    youtubeDLDir.absolutePath.toString() + Constants.titleRegex
                )
                YoutubeDL.getInstance().execute(
                    request
                ) { progress, etaInSeconds, line ->
                    downloadVideoDataML.postValue(
                        DownloadVideoData(
                            progress = progress,
                            etaInSeconds = etaInSeconds,
                            line = line,
                            currentState = DownloadState.LOADING
                        )
                    )
                }
            } catch (e: Exception) {
                downloadVideoDataML.postValue(
                    DownloadVideoData(
                        progress = 0f,
                        etaInSeconds = 0,
                        line = "",
                        currentState = DownloadState.ERROR
                    )
                )
            }
        }
    }


    private val _linkTextField = MutableStateFlow("")
    val linkTextField = _linkTextField.asStateFlow()

    fun setName(name: String) {
        _linkTextField.value = name
    }
}