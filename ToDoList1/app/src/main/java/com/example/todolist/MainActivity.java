package com.example.todolist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText item;
    Button add;
    ListView listView;
    ArrayList<String> itemList = new ArrayList<>();//array list hold the item
    ArrayAdapter<String> arrayAdapter;//array adapter to connect the array list and list view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item = findViewById(R.id.editText);//access the view
        add = findViewById(R.id.button);
        listView = findViewById(R.id.list);

        itemList=FileHelper.readData(this);//readdata and then send into array list if there is any data

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1,itemList);//arrayadapter used to connect listview
        listView.setAdapter(arrayAdapter);//in listview
        add.setOnClickListener(new View.OnClickListener() {//on click event
            @Override
            public void onClick(View view) {
                String itemName = item.getText().toString();//using string container
                itemList.add(itemName);
                item.setText("");//clear the text of edit text
                FileHelper.writeData(itemList,getApplicationContext());
                arrayAdapter.notifyDataSetChanged();




            }
        });
        //for delete item (set on click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);//alert message
                alert.setTitle("Delete");//delete message
                alert.setMessage(" Do you want to delete this item from list?");
                alert.setCancelable(false);
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();//if the user click no then alert dialog close
                    }
                });
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        itemList.remove(position);
                            arrayAdapter.notifyDataSetChanged();
                            FileHelper.writeData(itemList,getApplicationContext());
                    }
                });
                AlertDialog alertDialog = alert.create();
                alertDialog.show();

            }
        });
    }
}