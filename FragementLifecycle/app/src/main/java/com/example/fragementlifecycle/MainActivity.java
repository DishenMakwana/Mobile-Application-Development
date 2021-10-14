package com.example.fragementlifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectFragment(View view) {

        // creating object for Fragment
        Fragment fr;

        // displaying first fragment
        // if button1 is clicked
        if(view == findViewById(R.id.button1)) {
            fr = new FragmentOne();
        }

        // displaying second fragment
        // if button2 is clicked
        else {
            fr = new FragmentTwo();
        }

        FragmentManager fm = getFragmentManager();

        // fragment transaction to add or replace
        // fragments while activity is running
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        final FragmentTransaction replace = fragmentTransaction.replace(R.id.fragment_section, fr.requireParentFragment());

        // making a commit after the transaction
        // to assure that the change is effective
        fragmentTransaction.commit();
    }
}
