package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onColorButtonClick(View view) {
        int colorResId = 0;
        int textColorResId = R.color.black;

        switch (view.getId()) {
            case R.id.red:
                colorResId = R.color.red;
                break;
            case R.id.green:
                colorResId = R.color.green;
                break;
            case R.id.blue:
                colorResId = R.color.blue;
                break;
            case R.id.gray:
                colorResId = R.color.gray;
                break;
        }

        if (colorResId != 0) {
            LinearLayout layout = findViewById(R.id.my_layout);
            layout.setBackgroundResource(colorResId);
            textColorResId = R.color.white;

            TextView textView = findViewById(R.id.my_textview);
            textView.setTextColor(getResources().getColor(textColorResId));
        }
    }
}