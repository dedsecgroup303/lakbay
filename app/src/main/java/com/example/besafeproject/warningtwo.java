package com.example.besafeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class warningtwo extends AppCompatActivity {
    Button nexxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warningtwo);

        nexxt=findViewById(R.id.nextt);

        nexxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r = new Intent(warningtwo.this,Mapa.class);
                startActivity(r);
            }
        });
    }
}
