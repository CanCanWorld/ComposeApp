package com.zrq.composeapp.ui.components

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.compose.runtime.*
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun MyWebView(state: MyWebViewState) {
    AndroidView(factory = {
        WebView(it)
    }) { view ->
        when (val content = state.content) {
            is WebContent.Url -> {
                val url = content.url
                if (url.isNotEmpty() && url != view.url) {
                    view.loadUrl(content.url)
                }
            }
            is WebContent.Data -> {
                view.loadDataWithBaseURL(
                    content.baseUrl,
                    content.data,
                    null,
                    "UTF-8",
                    null
                )
            }
        }
    }
}

sealed class WebContent() {
    data class Url(val url: String) : WebContent()
    data class Data(val data: String, val baseUrl: String? = null) : WebContent()
}

class MyWebViewState(webContent: WebContent) {
    //网页内容：url or data
    var content by mutableStateOf(webContent)

    var pageTitle: String? by mutableStateOf(null)
}

@Composable
fun rememberWebViewState(url: String) = remember(key1 = url) {
    MyWebViewState(WebContent.Url(url))
}

@Composable
fun rememberWebViewState(data: String, baseUrl: String? = null) = remember(key1 = data, key2 = baseUrl) {
    MyWebViewState(WebContent.Data(data, baseUrl))
}


