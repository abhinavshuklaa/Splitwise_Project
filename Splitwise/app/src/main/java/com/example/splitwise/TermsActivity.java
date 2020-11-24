package com.example.splitwise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class TermsActivity extends AppCompatActivity {

    private WebView wv_terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
        initViews();
    }

    private void initViews() {

        wv_terms = (WebView) findViewById(R.id.wv_terms);
        wv_terms.loadUrl("https://www.splitwise.com/terms");
    }
}