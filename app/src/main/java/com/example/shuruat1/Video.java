package com.example.shuruat1;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Video extends AppCompatActivity {
    ListView lv;
    FloatingActionButton fab;
    //    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        getSupportActionBar().hide();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fab = findViewById(R.id.fab);
//        replaceFragment(new HomeFragment());

        bottomNavigationView.setBackground(null);
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
                    startActivity(new Intent(getApplicationContext(),about.class));
                    overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
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
        lv = findViewById(R.id.lv);

        String[] data = {"What is Financial Literacy-Introduction","Financial Literacy-Goods and Services"};
        Integer[] imgid = {R.drawable.fina,R.drawable.part};
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), data, imgid);
        lv.setAdapter(customAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    startActivity(new Intent(Video.this, intro.class));
                } else if (i==1) {
                    startActivity(new Intent(Video.this, part1.class));

                }
            }
        });
    }

    public class CustomAdapter extends ArrayAdapter<String> {
        private final Context context;
        private final String[] data;
        private final Integer[] imgid;

        public CustomAdapter(@NonNull Context context, String[] data, Integer[] imgid) {
            super(context, R.layout.customlist, data);
            this.context = context;
            this.data = data;
            this.imgid = imgid;
        }

        @SuppressLint("ViewHolder")
        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            @SuppressLint("InflateParams") View v1 = inflater.inflate(R.layout.customlist, null);
            ImageView img = v1.findViewById(R.id.img);
            TextView name = v1.findViewById(R.id.name);
            img.setImageResource(imgid[position]);
            name.setText(data[position]);
            return v1;
        }

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
                Intent intent = new Intent(Video.this,phoneauth.class);
                startActivity(intent);

            }
        });

        shortsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                return;

            }
        });

        liveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                Toast.makeText(Video.this,"Updated soon",Toast.LENGTH_SHORT).show();

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