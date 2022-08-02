package com.maden.m_downloader.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.maden.m_downloader.R
import com.maden.m_downloader.model.DownloadState
import com.maden.m_downloader.util.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: DownloadVideoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(DownloadVideoViewModel::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.downloadVideo(Constants.testUrl)
        }
        observeData()
    }

    private fun observeData(){
        viewModel.downloadVideoLiveData.observe(this) {
            it?.let {
                if (it.currentState == DownloadState.START) {

                }
                if (it.currentState == DownloadState.ERROR) {

                }
                if (it.currentState == DownloadState.FINISH) {

                }
                if (it.currentState == DownloadState.LOADING) {

                }
            }
        }
    }
}