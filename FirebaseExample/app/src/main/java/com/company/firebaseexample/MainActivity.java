package com.company.firebaseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

     EditText mail;
     EditText password;
     Button signin;
     Button signup;
     Button forgotpassword;
     Button phoneSign;

     FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail=findViewById(R.id.editTextTextEmaill);
        password=findViewById(R.id.editTextPassword);
        signin=findViewById(R.id.Sign_inButtton);
        signup=findViewById(R.id.signupbutton);
        forgotpassword=findViewById(R.id.ForgetButton);
        phoneSign=findViewById(R.id.buttonPhoneSign);

        phoneSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,phoneSignActivity.class);
                startActivity(i);
                finish();

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userMail = mail.getText().toString();
                String userPassword = password.getText().toString();
                signFirebase(userMail,userPassword);

            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SignUp.class);
                startActivity(i);


            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ForgetActivity.class);
                startActivity(i);

            }
        });


    }

    public void signFirebase(String userMail,String userPassword)
    {
        auth.signInWithEmailAndPassword(userMail, userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                             Intent i = new Intent(MainActivity.this,Main_Menu.class);
                             startActivity(i);
                             finish();


                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(MainActivity.this,"Incorrect mail or password ",Toast.LENGTH_SHORT).show();

                        }
                    }
                });


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = auth.getCurrentUser();
        if(user !=null)
        {
            Intent i = new Intent(MainActivity.this,Main_Menu.class);
            startActivity(i);
            finish();

        }
    }
}