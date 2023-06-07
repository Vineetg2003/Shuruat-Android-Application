package com.example.shuruat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class about extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_about);
        button = (Button) findViewById(R.id.button12);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openhomepage();
            }
        });
        button = (Button) findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opencontact();
            }
        });
    }
    public void openhomepage() {
        Intent intent = new Intent(this, homepage.class);
        startActivity(intent);
    }
    public void opencontact() {
        Intent intent = new Intent(this, contact.class);
        startActivity(intent);
    }
    int counter =0;
    @Override
    public void onBackPressed() {


        counter++;
        if(counter==2)
            super.onBackPressed();
    }
}