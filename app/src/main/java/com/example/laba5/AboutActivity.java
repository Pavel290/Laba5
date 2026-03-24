package com.example.laba5;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        SharedPreferences prefs = getSharedPreferences("AppSettings", MODE_PRIVATE);
        int textSize = prefs.getInt("text_size", 24);

        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvFIO   = findViewById(R.id.tvFIO);
        TextView tvGroup = findViewById(R.id.tvGroup);

        tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        tvFIO.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        tvGroup.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
    }
}