package com.example.shuruat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_homepage);
        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openabout();
            }
        });
        button = (Button) findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opencontact();
            }
        });
    }

    public void openabout() {
        Intent intent = new Intent(this, about.class);
        startActivity(intent);
    }
    public void opencontact() {
        Intent intent = new Intent(this, contact.class);
        startActivity(intent);
    }

}