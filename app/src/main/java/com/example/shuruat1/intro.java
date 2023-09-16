package com.example.shuruat1;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class intro extends AppCompatActivity {
    VideoView vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_shayad);
        vv=findViewById(R.id.shayad);
        vv.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.intro);

        MediaController med=new MediaController(this);
        vv.setMediaController(med);
        med.setAnchorView(vv);
        vv.start();
    }
}