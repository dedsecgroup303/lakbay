package com.example.besafeproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Riderinfo extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    TextView namee,agee,parentnamee,parentcontacte,addresse;
    private static final String mypref="info";
    private static final String myname="name";
    private static final String myusername="username";
    private static final String mypassword="password";
    private static final String mygpname="gpname";
    private static final String mygpmobilenumber="gpmobilenumber";
    private static final String myaddress="myaddress";
    private static final String myage="myage";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riderinfo);
        namee = findViewById(R.id.name);
        agee = findViewById(R.id.age);
        parentnamee = findViewById(R.id.parentname);
        parentcontacte = findViewById(R.id.contactnumber);
        addresse = findViewById(R.id.address);

        sharedPreferences=getSharedPreferences(mypref,MODE_PRIVATE);

        String registerdname =sharedPreferences.getString(myname,"");
        String registergpname =sharedPreferences.getString(mygpname,"");
        String registergpmobilenumber =sharedPreferences.getString(mygpmobilenumber,"");
        String registerage =sharedPreferences.getString(myage,"");
        String registerdaddress =sharedPreferences.getString(myaddress,"");

        namee.setText(registerdname);
        agee.setText(registerage);
        parentcontacte.setText(registergpmobilenumber);
        parentnamee.setText(registergpname);
        addresse.setText(registerdaddress);



//        try {
//            FileInputStream streamname = openFileInput(myname);
//            String name ="";
//            int Lename;
//            while ((Lename = streamname.read())!=-1){
//                name = name + Character.toString((char) + Lename );
//
//            }
//            FileInputStream streamage = openFileInput(myage);
//            String age ="";
//            int Leage;
//            while ((Leage = streamage.read())!=-1){
//                age = age + Character.toString((char) + Leage );
//
//            }
//            FileInputStream streamparentname = openFileInput(mygpname);
//            String parentname ="";
//            int Leparentname;
//            while ((Leparentname = streamparentname.read())!=-1){
//                parentname = parentname + Character.toString((char) + Leparentname );
//
//            }
//            FileInputStream streamparentnumber = openFileInput(mygpmobilenumber);
//            String parentnumber ="";
//            int Leparentnumber;
//            while ((Leparentnumber = streamage.read())!=-1){
//                parentnumber = parentnumber + Character.toString((char) + Leparentnumber );
//
//            }
//            FileInputStream streamaddress = openFileInput(myaddress);
//            String address ="";
//            int Leaddress;
//            while ((Leaddress = streamaddress.read())!=-1){
//                address = address + Character.toString((char) + Leaddress );
//
//            }
//            namee.setText(name);
//            agee.setText(age);
//            parentcontacte.setText(parentnumber);
//            parentnamee.setText(parentname);
//            addresse.setText(address);
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
