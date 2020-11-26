package com.example.splitwise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class TermsActivity extends AppCompatActivity {

    private TextView tv_backtoLogInAndSignUpTerms;

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

        tv_backtoLogInAndSignUpTerms = findViewById(R.id.tv_backtoLogInAndSignUpTerms);
        tv_backtoLogInAndSignUpTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TermsActivity.this, LogInAndSignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}