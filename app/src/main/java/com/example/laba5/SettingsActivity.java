package com.example.laba5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Set;

public class SettingsActivity extends AppCompatActivity {

    private RadioButton rbBigText;
    private RadioButton rbMedText;
    private RadioButton rbMiniText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageButton backButton = findViewById(R.id.buttonBack);
        Button btnSave = findViewById(R.id.btnSave);

        rbBigText = findViewById(R.id.BigText);
        rbMedText = findViewById(R.id.MedText);
        rbMiniText = findViewById(R.id.MiniText);

        // Кнопка назад
        backButton.setOnClickListener(v -> finish());

        // Кнопка Сохранить
        btnSave.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("AppSettings", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            if (rbBigText.isChecked()) {
                editor.putInt("text_size", 34);
            } else if (rbMedText.isChecked()) {
                editor.putInt("text_size", 24);
            } else if (rbMiniText.isChecked()) {
                editor.putInt("text_size", 18);
            } else {
                editor.putInt("text_size", 24);
            }

            editor.apply();

            setResult(RESULT_OK);
            finish();
        });

        // Живой предпросмотр в окне настроек
        View.OnClickListener preview = v -> {
            TextView previewText = findViewById(R.id.WindText);
            if (rbBigText.isChecked()) previewText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 34);
            else if (rbMedText.isChecked()) previewText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
            else if (rbMiniText.isChecked()) previewText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        };

        rbBigText.setOnClickListener(preview);
        rbMedText.setOnClickListener(preview);
        rbMiniText.setOnClickListener(preview);
    }
}