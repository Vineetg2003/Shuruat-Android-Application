package com.example.shuruat1;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class part1 extends AppCompatActivity {

    VideoView vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_part1);
        vv=findViewById(R.id.part1);
        vv.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.part);

        MediaController med=new MediaController(this);
        vv.setMediaController(med);
        med.setAnchorView(vv);
        vv.start();
    }
}













