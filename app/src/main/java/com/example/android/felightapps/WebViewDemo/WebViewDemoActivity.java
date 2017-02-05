package com.example.android.felightapps.WebViewDemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.android.felightapps.R;

public class WebViewDemoActivity extends AppCompatActivity {

    private WebView mWebView;
    private ProgressBar mWebViewProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_demo);

        mWebView = (WebView) findViewById(R.id.wv_webview);
        mWebViewProgressBar = (ProgressBar) findViewById(R.id.pb_webview_progressBar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mWebViewProgressBar.setVisibility(View.INVISIBLE);
            }
        });

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("https://www.google.co.in");
    }
}
