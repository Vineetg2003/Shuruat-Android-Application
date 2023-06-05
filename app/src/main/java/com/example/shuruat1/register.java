package com.example.shuruat1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shuruat1.databinding.ActivityMainBinding;
import com.example.shuruat1.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    ActivityRegisterBinding binding;
    String name,email_id,contact,adhaar,Father_Occupation,Income,Educational_Institue,Description;
    FirebaseDatabase db;
    DatabaseReference reference;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                name = binding.editTextTextPersonName5.getText().toString();
                email_id = binding.editTextTextEmailAddress.getText().toString();
                contact = binding.editTextPhone.getText().toString();
                adhaar = binding.editTextPhone2.getText().toString();
                Father_Occupation = binding.editTextTextPersonName8.getText().toString();
                Income = binding.editTextTextPersonName9.getText().toString();
                Educational_Institue = binding.editTextTextPersonName10.getText().toString();
                Description = binding.editTextTextPersonName11.getText().toString();

                editfeild();
                DatabaseReference presenceRef = FirebaseDatabase.getInstance().getReference("disconnectmessage");
                presenceRef.onDisconnect().setValue("I disconnected!");

                if (!name.isEmpty() && !email_id.isEmpty() && !contact.isEmpty() && !adhaar.isEmpty() && !Father_Occupation.isEmpty() && !Income.isEmpty() && !Educational_Institue.isEmpty() && !Description.isEmpty()){
                    User user = new User(name,email_id,contact,adhaar,Father_Occupation,Income,Educational_Institue,Description);
                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference();
                    reference.child("User").child(name).child(email_id).child(contact).child(adhaar)
                            .child(Father_Occupation).child(Income).child(Educational_Institue)
                            .child(Description).setValue(user);
                }

            }
        });
        TextView btn=findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register.this,Login.class));

            }
        });





        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openLogin();
            }
        });
    }

    public void editfeild() {
        binding.editTextTextPersonName5.setText("");
        binding.editTextTextEmailAddress.setText("");
        binding.editTextPhone.setText("");
        binding.editTextPhone2.setText("");
        binding.editTextTextPersonName8.setText("");
        binding.editTextTextPersonName9.setText("");
        binding.editTextTextPersonName10.setText("");
        binding.editTextTextPersonName11.setText("");

    }
    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}