package com.example.besafeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class signup extends AppCompatActivity {


    EditText name, usernamee, passwords, gpname, gpmobilenumber, address, age;
    Button submit;



    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private static final String mypref="info";
    private static final String myname="name";
    private static final String myusername="username";
    private static final String mypassword="password";
    private static final String mygpname="gpname";
    private static final String mygpmobilenumber="gpmobilenumber";
    private static final String myaddress = "myaddress";
    private static final String myage = "myage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        name = findViewById(R.id.name);
        usernamee = findViewById(R.id.usernamee);
        passwords = findViewById(R.id.passwords);
        gpname = findViewById(R.id.gpname);
        gpmobilenumber = findViewById(R.id.gpmobilenumber);
        address = findViewById(R.id.address);
        age = findViewById(R.id.age);
        submit = findViewById(R.id.submit);


        sharedPreferences=getSharedPreferences(mypref,MODE_PRIVATE);
        editor=sharedPreferences.edit();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



        String stusername = usernamee.getText().toString();
        String stpassword = passwords.getText().toString();
        String stgpname = gpname.getText().toString();
        String stgpmobilenumber = gpmobilenumber.getText().toString();
        String stage = age.getText().toString();
        String staddress = address.getText().toString();
        String stname = name.getText().toString();

//
//
//        try {
//            FileOutputStream fileOutputStreamname = openFileOutput(myname,MODE_PRIVATE);
//            FileOutputStream fileOutputStreamusername = openFileOutput(myusername,MODE_PRIVATE);
//            FileOutputStream fileOutputStreampassword = openFileOutput(mypassword,MODE_PRIVATE);
//            FileOutputStream fileOutputStreamgpname = openFileOutput(mygpname,MODE_PRIVATE);
//            FileOutputStream fileOutputStreamgpmobilenumber = openFileOutput(mygpmobilenumber,MODE_PRIVATE);
//            FileOutputStream fileOutputStreamaddress = openFileOutput(myaddress,MODE_PRIVATE);
//            FileOutputStream fileOutputStreamage = openFileOutput(myage,MODE_PRIVATE);
//
//            fileOutputStreamname.write(stname.getBytes());
//            fileOutputStreamusername.write(stusername.getBytes());
//            fileOutputStreampassword.write(stpassword.getBytes());
//            fileOutputStreamgpname.write(stgpname.getBytes());
//            fileOutputStreamgpmobilenumber.write(stgpmobilenumber.getBytes());
//            fileOutputStreamaddress.write(staddress.getBytes());
//            fileOutputStreamage.write(stage.getBytes());
//
//            fileOutputStreamname.close();
//            fileOutputStreamusername.close();
//            fileOutputStreampassword.close();
//            fileOutputStreamgpname.close();
//            fileOutputStreamgpmobilenumber.close();
//            fileOutputStreamaddress.close();
//            fileOutputStreamage.close();
//
//
////                    Toast.makeText(signup.this, "added", Toast.LENGTH_SHORT).show();
//            Intent i = new Intent(signup.this,login.class);
//            startActivity(i);
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
////
                editor.putString(myname,stname);
                editor.putString(myusername,stusername);
                editor.putString(mypassword,stpassword);
                editor.putString(mygpname,stgpname);
                editor.putString(mygpmobilenumber,stgpmobilenumber);
                editor.putString(myaddress,staddress);
                editor.putString(myage,stage);
                editor.commit();
                Intent i = new Intent(signup.this,splashscreen.class);
                startActivity(i);

            }
        });

    }
}
//