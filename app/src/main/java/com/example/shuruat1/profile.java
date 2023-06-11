package com.example.shuruat1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class profile extends AppCompatActivity {
    private Button button;
    TextView fullName , email, phone;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_profile);
//fullName = findViewById(R.id.editTextTextPersonName13);
//phone = findViewById(R.id.editTextTextPersonName15);
//email = findViewById(R.id.editTextTextPersonName16);
//fAuth = FirebaseAuth.getInstance();
//fstore = FirebaseFirestore.getInstance();
//userId = fAuth.getCurrentUser().getUid();
//        DocumentReference documentReference = fstore.collection("User").document("sIZSmtQTq4eWz31StpFR");
//        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
//                phone.setText(documentSnapshot.getString("Contact"));
//                fullName.setText(documentSnapshot.getString("name"));
//                email.setText(documentSnapshot.getString("Email_ID"));
//            }
//        });



//        START
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) BottomNavigationView bottomNavigationView =findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.profile1);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home1:
                    startActivity(new Intent(getApplicationContext(),homepage.class));
                    overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
                    return true;

                case R.id.profile1:
                    return true;
                case R.id.image1:
                    Toast.makeText(this, "Updated Soon", Toast.LENGTH_SHORT).show();
//                    finish();
                    return true;
                case R.id.about1:
                    startActivity(new Intent(getApplicationContext(),about.class));
                    overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
//                    finish();
                    return true;
                case R.id.Contact1:
                    startActivity(new Intent(getApplicationContext(),contact.class));
                    overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
                    return true;
            }
            return false;
        });
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openLogin();
            }
        });
//        ENDASDFGHJKL

    }
//    START
    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
//    END

}