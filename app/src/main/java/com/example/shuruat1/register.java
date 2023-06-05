package com.example.shuruat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shuruat1.databinding.ActivityRegisterBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.editTextTextPersonName5.getText().toString();
                String emailId = binding.editTextTextEmailAddress.getText().toString();
                String contact = binding.editTextPhone.getText().toString();
                String adhaar = binding.editTextPhone2.getText().toString();
                String fatherOccupation = binding.editTextTextPersonName8.getText().toString();
                String income = binding.editTextTextPersonName9.getText().toString();
                String educationalInstitute = binding.editTextTextPersonName10.getText().toString();
                String Password = binding.editTextTextPersonName11.getText().toString();

                if (!name.isEmpty() && !emailId.isEmpty() && !contact.isEmpty() && !adhaar.isEmpty() && !fatherOccupation.isEmpty() && !income.isEmpty() && !educationalInstitute.isEmpty() && !Password.isEmpty()) {
                    User user = new User(name, emailId, contact, adhaar, fatherOccupation, income, educationalInstitute, Password);
                    reference = FirebaseDatabase.getInstance().getReference().child("User");
                    reference.push().setValue(user);

                    Toast.makeText(register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    clearFields();
                } else {
                    Toast.makeText(register.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView loginTextView = findViewById(R.id.login);
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register.this,Login.class));
            }
        });
    }

    private void clearFields() {
        binding.editTextTextPersonName5.setText("");
        binding.editTextTextEmailAddress.setText("");
        binding.editTextPhone.setText("");
        binding.editTextPhone2.setText("");
        binding.editTextTextPersonName8.setText("");
        binding.editTextTextPersonName9.setText("");
        binding.editTextTextPersonName10.setText("");
        binding.editTextTextPersonName11.setText("");
    }
}
