package com.example.exercise4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3;
    Button button;
    TextView textViewDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        button = findViewById(R.id.button);
        textViewDisplay = findViewById(R.id.textView_display);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText1.getText().toString();
                String phone = editText2.getText().toString();
                String email = editText3.getText().toString();

                String contactInfo = "Name: " + name + "\nEmail: " + phone + "\nProject: " + email;
                textViewDisplay.setText(contactInfo);

                // Hide the input fields
                editText1.setVisibility(View.GONE);
                editText2.setVisibility(View.GONE);
                editText3.setVisibility(View.GONE);
            }
        });
    }
}