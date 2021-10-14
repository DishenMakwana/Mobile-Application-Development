package com.company.firebaseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class phoneSignActivity extends AppCompatActivity {

    EditText phoneNumber;
    Button sendCode;
    EditText smsCode;
    Button signWithPhone;
    String sentCode;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_sign);

        phoneNumber = findViewById(R.id.editTextPhoneNo);
        sendCode=findViewById(R.id.buttonsendsms);
        smsCode=findViewById(R.id.editTextCode);
        signWithPhone=findViewById(R.id.buttonPhoneSign);

        sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userPhoneNumber=phoneNumber.getText().toString();
                PhoneAuthProvider.getInstance().verifyPhoneNumber(userPhoneNumber,60, TimeUnit.SECONDS,phoneSignActivity.this,mCallBack);

            }
        });

        signWithPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSignWithPhonecode();


            }
        });

    }

    public void setSignWithPhonecode()
    {
        String enterUserCode=smsCode.getText().toString();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(sentCode,enterUserCode);
        setSignWithPhoneAuthCredential(credential);

    }

    public void setSignWithPhoneAuthCredential(PhoneAuthCredential credential)
    {
          auth.signInWithCredential(credential)
                  .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task) {
                          if(task.isSuccessful())
                          {
                              Intent i = new Intent(phoneSignActivity.this,Main_Menu.class);
                              startActivity(i);
                              finish();
                          }
                          else
                          {
                              Toast.makeText(phoneSignActivity.this,"Incorrect Code",Toast.LENGTH_SHORT).show();
                          }

                      }
                  });
    }
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {

        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            sentCode = s;

        }
    };
}