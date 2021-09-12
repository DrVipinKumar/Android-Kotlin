package edu.kiet.kietapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    lateinit var webView: WebView
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val url:String="https://www.kiet.edu"
        webView=findViewById(R.id.webView) as WebView
        webView.settings.javaScriptEnabled=true
        webView.webViewClient= WebViewClient()
        webView.loadUrl(url)
    }

    override fun onBackPressed() {
        if(webView.canGoBack())
        {
            webView.goBack()
        }
        else {
            super.onBackPressed()
        }
    }

}