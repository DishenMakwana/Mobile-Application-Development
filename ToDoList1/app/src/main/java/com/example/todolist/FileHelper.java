package com.example.todolist;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHelper {//save the data

    public static final String FILENAME = "listinfo.dat";//here i declare the file name that i want to save onto device memory

    public static void writeData(ArrayList<String> item, Context context)//writedata method to write the data to this file
       {
           try {
               FileOutputStream fos = context.openFileOutput(FILENAME,Context.MODE_PRIVATE);//using try catch , fos object and using
               // fileoutputstream we can write the data,this code will create a file in device memory
               ObjectOutputStream oas = new ObjectOutputStream(fos);//write data in file
               oas.writeObject(item);//here item is written in file
               oas.close();//close the file
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }

       }
       public static ArrayList<String> readData(Context context)//read the file only with one argument
       {
           ArrayList<String> itemList = null;//start from null value in beginning

           try {
               FileInputStream fis = context.openFileInput(FILENAME);//open file for    read the data from file
               ObjectInputStream ois = new ObjectInputStream(fis);//read the data from file
               itemList = (ArrayList<String>) ois.readObject();//convert the array in to string
           } catch (FileNotFoundException e) {
               itemList = new ArrayList<>();
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }
           return itemList;//return itemlist
       }
}
