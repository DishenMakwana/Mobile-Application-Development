package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "We got the answer", Toast.LENGTH_SHORT).show();
                String s = editText.getText().toString();
//                int kg = Integer.parseInt(s);
                double meter = Double.parseDouble(s);
                double centimeter = 100 * meter;
                double kilometer = meter / 1000;
//                double pound = 2.205 * kg ;
                textView.setText("Centimeter : " + centimeter + "cm | Kilometer : "+ kilometer + "km");
            }
        });
    }
}