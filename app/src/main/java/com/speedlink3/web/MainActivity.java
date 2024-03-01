package com.speedlink3.web;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView spl3Web;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spl3Web = findViewById(R.id.spl3Web);
        spl3Web.getSettings().setJavaScriptEnabled(true);
        spl3Web.setWebViewClient(new WebViewClient());
        spl3Web.loadUrl("http://www.speedlink3.net/");

    }
}