package com.example.shuruat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Our_Vision extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_our_vision);
        button = (Button) findViewById(R.id.button25);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openhomepage();
            }
        });
        button = (Button) findViewById(R.id.button24);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opencontact();
            }
        });
        button = (Button) findViewById(R.id.button23);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openabout();
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
    public void openabout() {
        Intent intent = new Intent(this,about.class);
        startActivity(intent);
    }
}