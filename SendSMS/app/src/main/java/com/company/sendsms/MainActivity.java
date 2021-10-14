package com.company.sendsms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button send;
    EditText message,number;

    String userMessage;
    String userNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send=findViewById(R.id.buttonSend);
        message=findViewById(R.id.editTextMessage);
        number=findViewById(R.id.editTextNumber);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userMessage = message.getText().toString();
                userNumber = number.getText().toString();

                sendSMS(userMessage,userNumber);
            }
        });
    }

       public void sendSMS(String userMessage,String userNumber)
       {
           if(ContextCompat.checkSelfPermission(this
                   , Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)//permission
           {
               ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
           }
           else
           {
               SmsManager smsManager = SmsManager.getDefault();
               smsManager.sendTextMessage(userNumber,null,userMessage,null,null);
           }
       }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==1 && grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
        {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(userNumber,null,userMessage,null,null);

        }
    }
}