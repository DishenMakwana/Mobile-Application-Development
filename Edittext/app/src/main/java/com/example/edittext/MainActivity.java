package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText
                = (EditText)findViewById(R.id.edittext_id);
        button
                = (Button)findViewById(R.id.button_id);

        button.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v)
                    {
                        String name
                                = editText.getText()
                                .toString();
                        Toast.makeText(MainActivity.this,
                                "Welcome to My World "
                                        + name,
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });
    }
}