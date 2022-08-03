package com.maden.m_downloader.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maden.m_downloader.R
import com.maden.m_downloader.view.download_activity.DownloadActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, DownloadActivity::class.java)
        startActivity(intent)
    }
}