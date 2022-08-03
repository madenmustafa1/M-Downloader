package com.maden.m_downloader.view.download_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maden.m_downloader.R
import com.maden.m_downloader.model.DownloadState
import com.maden.m_downloader.model.DownloadVideoData
import com.maden.m_downloader.util.Constants
import com.maden.m_downloader.view.ui.theme.MDownloaderTheme
import com.maden.m_downloader.widgets.CustomSpacer
import com.maden.m_downloader.widgets.DefaultButton
import com.maden.m_downloader.widgets.DefaultText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DownloadActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MDownloaderTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DownloadPage()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MDownloaderTheme { DownloadPage() }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DownloadPage(
    viewModel: DownloadVideoViewModel = viewModel()
) {
    val linkTextField = viewModel.linkTextField.collectAsState()
    val data = viewModel.downloadVideoLiveData.observeAsState()

    Scaffold(
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomSpacer()
                //Title
                DefaultText(
                    stringResource(id = R.string.download_activity_title),
                    paddingValue = 10,
                    fontWeight = FontWeight.Bold
                )
                CustomSpacer(Constants.smallPaddingValue)
                //EditText
                TextField(
                    value = linkTextField.value,
                    onValueChange = viewModel::setName
                )
                CustomSpacer(Constants.mediumPaddingValue)
                DefaultButton(stringResource(id = R.string.download_button)) {
                    CoroutineScope(Dispatchers.IO).launch {
                        viewModel.downloadVideo(linkTextField.value)
                    }
                }
            }
        }
    )

    dataHandle(data.value)
}

private fun dataHandle(data: DownloadVideoData?) {
    data?.let {
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


