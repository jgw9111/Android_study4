package com.example.webapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.main );
        WebView webView = findViewById(R.id.webView);
        final Context _this = Main.this;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient());
        webView.addJavascriptInterface(new Object(){
            @android.webkit.JavascriptInterface
            public void showToast(String msg){
                Toast.makeText(_this,msg, Toast.LENGTH_LONG).show();
            }

        },"hybrid");
        webView.loadUrl("file:///android_asset/www/index.html");

    }
}