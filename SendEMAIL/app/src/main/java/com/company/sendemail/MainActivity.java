package com.company.sendemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button send;
    EditText address,message,subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        address=findViewById(R.id.EmailAddress);
        message=findViewById(R.id.EmailMessage);
        subject=findViewById(R.id.EmailSubject);
        send=findViewById(R.id.buttonsendemail);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userAddress=address.getText().toString();//text to string
                String userMessage=message.getText().toString();
                String userSubject=subject.getText().toString();

                sendEmail(userAddress,userSubject,userMessage);//onclick event
            }
        });
    }
    public void sendEmail(String userAddress,String userSubject,String userMessage)//mail sending method
    {
           String[] emailAddress = {userAddress}; //email address   store in array
        Intent emailIntent = new Intent(Intent.ACTION_SEND);//sending mail, it switch one activity to another activity
        emailIntent.setData(Uri.parse("mailto:"));//send data as a email
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL,emailAddress);//data will send into mail address section
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,userSubject);//data will send into subject section
        emailIntent.putExtra(Intent.EXTRA_TEXT,userMessage);//data will send into user message section
        startActivity(Intent.createChooser(emailIntent,"email send"));//user choice
    }
}