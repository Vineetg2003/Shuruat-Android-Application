package com.example.shuruat1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openregister();
            }
        });
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openLogin();
            }
        });
        button = (Button) findViewById(R.id.button15);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openabout1();
            }
        });
        button = (Button) findViewById(R.id.button18);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openOur_Vision();
            }
        });
    }
        public void openregister() {
            Intent intent = new Intent(this, register.class);
            startActivity(intent);
        }
    public void openLogin() {
        Intent intent = new Intent(this, Login.class);

        startActivity(intent);
    }
    public void openabout1() {
        Intent intent = new Intent(this, about1.class);
        startActivity(intent);
    }

    public void openOur_Vision() {
        Intent intent = new Intent(this, Our_Vision.class);
        startActivity(intent);
    }



    }
