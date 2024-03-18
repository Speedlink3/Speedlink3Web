package com.speedlink3.fireadcontrol;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

// =============================================================
// S M SHAHBAZ HOSSAIN SHOHAG
// Speedlink3 Communication And Technologies
// https://www.speedlink3.net and https://www.speedlink3.com
// Email: admin@speedlink3.net and spl3.com.tech@gmail.com
// https://github.com/speedlink3ct
// =============================================================

public class MainActivity extends AppCompatActivity {

    WebView webView;
    AdView adView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        adView = findViewById(R.id.adView);

        // step 1
        MobileAds.initialize(this);
        // step 2
        AdRequest adRequest = new AdRequest.Builder().build();
        // step 3
        adView.loadAd(adRequest);


        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.google.com/");

    }

}