package com.example.shuruat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    public void login(View view){
        Toast.makeText(this, "LOGIN SUCCESFULLY", Toast.LENGTH_SHORT).show();
    }
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openhomepage();
            }
        });
        TextView btn=findViewById(R.id.sign_up);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,register.class));

            }
        });
    }
    public void openhomepage() {
        Intent intent = new Intent(this, homepage.class);
        startActivity(intent);
    }

}