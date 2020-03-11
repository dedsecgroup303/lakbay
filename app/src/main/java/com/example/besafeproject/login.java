package com.example.besafeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class login extends AppCompatActivity {

    EditText username,password;
    Button login,signup;
//    SharedPreferences sharedPreferences;



    private static final String mypref="info";
    private static final String myname="name";
    private static final String myusername="username";
    private static final String mypassword="password";
    private static final String mygpname="gpname";
    private static final String mygpmobilenumber="gpmobilenumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);

//        sharedPreferences=getSharedPreferences(mypref,MODE_PRIVATE);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent p = new Intent(login.this,signup.class);
                startActivity(p);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userValue=username.getText().toString();
                String passValue=password.getText().toString();

                try {
                    FileInputStream streamusername=openFileInput(myusername);
                    String gname ="";
                    int lenName;

                    while ((lenName = streamusername.read()) !=-1){
                        gname =  gname + Character.toString((char) + lenName);

                    }
                    FileInputStream streampassword=openFileInput(mypassword);
                    String gpassword ="";
                    int lenpassword;

                    while ((lenpassword = streampassword.read()) !=-1){
                        gpassword =  gpassword + Character.toString((char) + lenpassword);

                    }
                    if (userValue.equals(gname) && passValue.equals(gpassword)){
                        Intent j = new Intent(login.this,mainmenu.class);
                        startActivity(j);

                    }else{
                        Toast.makeText(login.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


//                String registerdusername =sharedPreferences.getString(myusername,"");
//                String registerpassword =sharedPreferences.getString(mypassword,"");









            }
        });



    }
}
