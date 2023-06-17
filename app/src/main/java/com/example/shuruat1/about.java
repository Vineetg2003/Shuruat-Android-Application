package com.example.shuruat1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class about extends AppCompatActivity {
    public FloatingActionButton floatingActionButton;
    public void gallery22(View view){
        Toast.makeText(this, "Updated soon", Toast.LENGTH_SHORT).show();
    }
    private Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_about);
        floatingActionButton = findViewById(R.id.application);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(about.this,phoneauth.class);
                startActivity(intent);
            }
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) BottomNavigationView bottomNavigationView =findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.about);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    startActivity(new Intent(getApplicationContext(),homepage.class));
                    overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
                    return true;
                case R.id.profile:
                    startActivity(new Intent(getApplicationContext(),profile.class));
                    overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
                    return true;
                case R.id.about:

//                    finish();
                    return true;
                case R.id.Contact:
                    startActivity(new Intent(getApplicationContext(),contact.class));
                    overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
//                    finish();
                    return true;
            }
            return false;
        });

    }

}