package com.jagoanstudio.viewurl

import android.content.res.Configuration
import android.net.http.SslError
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webview.settings.javaScriptEnabled = true
        webview.settings.domStorageEnabled = true
        webview.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
                return super.onConsoleMessage(consoleMessage)
                Log.d("TEST consoleMessage", consoleMessage.toString())
            }

            override fun onConsoleMessage(message: String?, lineNumber: Int, sourceID: String?) {
                super.onConsoleMessage(message, lineNumber, sourceID)
                Log.d("TEST message", message.toString())
                Log.d("TEST lineNumber", lineNumber.toString())
                Log.d("TEST sourceID", sourceID.toString())
            }
        }
        webview.webViewClient = object : WebViewClient() {
            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
                Log.d("TEST errorCode", error?.errorCode.toString())
                Log.d("TEST description", error?.description.toString())

                empty.visibility = View.VISIBLE
                webview.visibility = View.GONE
            }

            override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
                super.onReceivedError(view, errorCode, description, failingUrl)
                Log.d("TEST errorCode", errorCode.toString())
                Log.d("TEST description", description)
                Log.d("TEST failingUrl", failingUrl)
            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                super.onReceivedSslError(view, handler, error)
                Log.d("TEST sslError", error?.toString())
            }
        }

        webview.loadUrl(intent.getStringExtra("url"))
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
    }

}

