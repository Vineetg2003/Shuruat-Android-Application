package com.example.shuruat1;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class profile extends AppCompatActivity {
    TextView profilename , profilecontact , profileemail , profileadhar , profileEdu , profilepass;
    private Button button;

    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String userId;
    FloatingActionButton fab;
    BottomNavigationView bottomNavigationView;
    ImageView buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_profile);

        profilename=findViewById(R.id.profilename);
        profilecontact=findViewById(R.id.profilecontact);
        profileemail=findViewById(R.id.profileemail);
        profileadhar=findViewById(R.id.profileadhar);
        profileEdu=findViewById(R.id.profileEdu);
        profilepass=findViewById(R.id.profilepass);

        showUserData();








        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fab = findViewById(R.id.fab);
        bottomNavigationView.setSelectedItemId(R.id.profile);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    startActivity(new Intent(getApplicationContext(),homepage.class));
                    overridePendingTransition(R.anim.slide_in_right , R.anim.slide_out_left);
                    return true;
                case R.id.profile:
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

        fab.setOnClickListener(view -> showBottomDialog());

        // Set up logout button
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openLogin();
            }
        });
    }

    // Open login activity
    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    // Show the bottom dialog
    private void showBottomDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        LinearLayout videoLayout = dialog.findViewById(R.id.layoutVideo);
        LinearLayout shortsLayout = dialog.findViewById(R.id.layoutShorts);
        LinearLayout liveLayout = dialog.findViewById(R.id.layoutLive);
        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);

        videoLayout.setOnClickListener(v -> {
            dialog.dismiss();
            Intent intent = new Intent(profile.this, phoneauth.class);
            startActivity(intent);
        });

        shortsLayout.setOnClickListener(v -> {
            dialog.dismiss();
            Intent intent = new Intent(profile.this, Video.class);
            startActivity(intent);
        });

        liveLayout.setOnClickListener(v -> {
            dialog.dismiss();
            Toast.makeText(profile.this, "Updated soon", Toast.LENGTH_SHORT).show();
        });

        cancelButton.setOnClickListener(view -> dialog.dismiss());

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }


    public void showUserData(){
        Intent intent=getIntent();
        String nameUser=intent.getStringExtra("name");
        String emailUser=intent.getStringExtra("email_id");
        String passUser=intent.getStringExtra("password");
        String EduUser=intent.getStringExtra("educational_Institue");
        String ContactUser=intent.getStringExtra("contact");
        String AdharUser=intent.getStringExtra("adhaar");

        profilename.setText(nameUser);
        profileemail.setText(emailUser);
        profilepass.setText(passUser);
        profileEdu.setText(EduUser);
        profilecontact.setText(ContactUser);
        profileadhar.setText(AdharUser);

    }

}



















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