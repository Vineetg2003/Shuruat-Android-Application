package com.example.shuruat1;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class contact extends AppCompatActivity {
    FloatingActionButton fab;
    BottomNavigationView bottomNavigationView;

    public void gallery122(View view){
        Toast.makeText(this, "Updated soon", Toast.LENGTH_SHORT).show();
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_contact);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fab = findViewById(R.id.fab);
//        replaceFragment(new HomeFragment());

        bottomNavigationView.setBackground(null);
        bottomNavigationView.setSelectedItemId(R.id.Contact);
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
                    startActivity(new Intent(getApplicationContext(),about.class));
                    overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
//                    finish();
                    return true;
                case R.id.Contact:
                    return true;
            }
            return false;
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomDialog();
            }
        });





    }
    private void showBottomDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        LinearLayout videoLayout = dialog.findViewById(R.id.layoutVideo);
        LinearLayout shortsLayout = dialog.findViewById(R.id.layoutShorts);
        LinearLayout liveLayout = dialog.findViewById(R.id.layoutLive);
        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);

        videoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Intent intent = new Intent(contact.this,phoneauth.class);
                startActivity(intent);

            }
        });

        shortsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Intent intent = new Intent(contact.this,Video.class);
                startActivity(intent);

            }
        });

        liveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(contact.this,"Updated soon",Toast.LENGTH_SHORT).show();

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }



}