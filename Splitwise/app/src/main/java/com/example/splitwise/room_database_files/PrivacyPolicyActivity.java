package com.example.splitwise.room_database_files;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.splitwise.LogInAndSignUpActivity;
import com.example.splitwise.R;

public class PrivacyPolicyActivity extends AppCompatActivity {
    private TextView tv_backtoLogInAndSignUpPrivacy;
    private WebView wv_privacy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        initViews();
    }
    private void initViews() {
        wv_privacy = (WebView) findViewById(R.id.wv_privacy);
        wv_privacy.loadUrl("https://www.splitwise.com/privacy");
        tv_backtoLogInAndSignUpPrivacy = findViewById(R.id.tv_backtoLogInAndSignUpPrivacy);
        tv_backtoLogInAndSignUpPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrivacyPolicyActivity.this, LogInAndSignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}