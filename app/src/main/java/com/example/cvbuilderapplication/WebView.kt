package com.example.cvbuilderapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*

class WebView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        val intent= intent
        val url=intent.getStringExtra("url").toString()
        when (url) {
            "linkedin" -> {
                openWebView(getString(R.string.my_linkedin))
            }
            "github" -> {
                openWebView(getString(R.string.my_github))
            }
            "location" -> {
                var loc = getString(R.string.mylocation)
                val addressUri ="geo:0,0?q=$loc"
                openWebView(addressUri)
            }
        }


    }

    fun openWebView(url:String){
        if(url.contains("geo:")) {
            web.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
        else {
            web.loadUrl(url)
            web.webViewClient = WebViewClient()
            web.settings.javaScriptEnabled = true
            web.settings.builtInZoomControls = true
        }
    }

    override fun onBackPressed() {
        var intent= Intent(this,ContactFragment::class.java)
        startActivity(intent)
    }
}