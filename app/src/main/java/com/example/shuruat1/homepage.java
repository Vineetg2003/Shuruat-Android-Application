package com.example.shuruat1;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homepage extends AppCompatActivity {
    FloatingActionButton fab;
//    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    Animation topAnim, bottomAnim;
    ImageView image;
//    public FloatingActionButton floatingActionButton;

//public void gallery(View view){
//    Toast.makeText(this, "Updated soon", Toast.LENGTH_SHORT).show();
//}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_homepage);


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fab = findViewById(R.id.fab);
//        replaceFragment(new HomeFragment());

        bottomNavigationView.setBackground(null);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.home:
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
                    startActivity(new Intent(getApplicationContext(),contact.class));
                    overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
                    return true;
            }

            return true;
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomDialog();
            }
        });


































//        ANIMATION
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        image = findViewById(R.id.imageView2);
        image.setAnimation(topAnim);
        image.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        },3000);


//        END


//        START
//        floatingActionButton = findViewById(R.id.application);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(homepage.this,phoneauth.class);
//                startActivity(intent);
//            }
//        });
//END
//        BottomNavigationView bottomNavigationView =findViewById(R.id.bottomNavigationView);
//        bottomNavigationView.setSelectedItemId(R.id.home);
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            switch (item.getItemId()){
//                case R.id.home:
//                return true;
//                case R.id.profile:
//                    startActivity(new Intent(getApplicationContext(),profile.class));
//                    overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
//                    return true;
//                case R.id.about:
//                    startActivity(new Intent(getApplicationContext(),about.class));
//                    overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
////                    finish();
//                    return true;
//                case R.id.Contact:
//                    startActivity(new Intent(getApplicationContext(),contact.class));
//                    overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
//                    return true;
//            }
//            return false;
//        });

    }
//    private  void replaceFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame_layout, fragment);
//        fragmentTransaction.commit();
//    }

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
                Intent intent = new Intent(homepage.this,phoneauth.class);
                startActivity(intent);

            }
        });

        shortsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Intent intent = new Intent(homepage.this,Video.class);
                startActivity(intent);

            }
        });

        liveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(homepage.this,"Updated soon",Toast.LENGTH_SHORT).show();

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






    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(homepage.this);
        alertDialog.setTitle("Exit App");
        alertDialog.setMessage("Do you want to exit?");
        alertDialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finishAffinity();
            }
        });
        alertDialog.show();
    }

}