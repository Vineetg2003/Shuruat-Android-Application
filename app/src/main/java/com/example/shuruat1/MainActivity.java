package com.example.shuruat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

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

                openabout();
            }
        });
        button = (Button) findViewById(R.id.button17);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openMission();
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
    public void openabout() {
        Intent intent = new Intent(this, about.class);
        startActivity(intent);
    }
    public void openMission() {
        Intent intent = new Intent(this, Mission.class);
        startActivity(intent);
    }
    public void openOur_Vision() {
        Intent intent = new Intent(this, Our_Vision.class);
        startActivity(intent);
    }



    }
