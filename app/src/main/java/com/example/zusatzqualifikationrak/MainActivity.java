package com.example.zusatzqualifikationrak;

import android.annotation.SuppressLint;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String indexhtml ="file:///android_asset/rak_zusatzleistungen.html";
        webView = this.findViewById(R.id.wv_index);
        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                Log.i("WebView", "Attempting to load URL: " + url);

                view.loadUrl(url);
                return true;
            }
        });
        WebSettings websetting = webView.getSettings();
        websetting.setJavaScriptEnabled(true);
        websetting.getJavaScriptCanOpenWindowsAutomatically();
        webView.setWebChromeClient(new WebChromeClient());
        if (savedInstanceState == null)
        {
            webView.loadUrl(indexhtml);
        }


    }
}
