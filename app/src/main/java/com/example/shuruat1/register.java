package com.example.shuruat1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        EditText nameEditText = findViewById(R.id.editTextTextPersonName5);
        EditText emailEditText = findViewById(R.id.editTextTextEmailAddress);
        EditText contactEditText = findViewById(R.id.editTextPhone);
        EditText adhaarEditText = findViewById(R.id.aadhar);
        EditText instituteEditText = findViewById(R.id.editTextTextPersonName10);
        EditText passwordEditText = findViewById(R.id.password);

        Button registerButton = findViewById(R.id.button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String emailId = emailEditText.getText().toString();
                String contact = contactEditText.getText().toString();
                String adhaar = adhaarEditText.getText().toString();
                String educationalInstitute = instituteEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (!name.isEmpty() && !emailId.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailId).matches()
                        && !contact.isEmpty() && !adhaar.isEmpty() && !educationalInstitute.isEmpty() && !password.isEmpty()) {

                    User user = new User(name, emailId, contact, adhaar, educationalInstitute, password);
                    reference = FirebaseDatabase.getInstance().getReference().child("Registration");
                    reference.push().setValue(user);

                    Toast.makeText(register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    clearFields();
                    Intent intent = new Intent(register.this, Login.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(register.this, "Please fill all the fields correctly", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView loginTextView = findViewById(R.id.login);
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register.this, Login.class));
            }
        });
    }

    private void clearFields() {
        EditText nameEditText = findViewById(R.id.editTextTextPersonName5);
        EditText emailEditText = findViewById(R.id.editTextTextEmailAddress);
        EditText contactEditText = findViewById(R.id.editTextPhone);
        EditText adhaarEditText = findViewById(R.id.aadhar);
        EditText instituteEditText = findViewById(R.id.editTextTextPersonName10);
        EditText passwordEditText = findViewById(R.id.password);

        nameEditText.setText("");
        emailEditText.setText("");
        contactEditText.setText("");
        adhaarEditText.setText("");
        instituteEditText.setText("");
        passwordEditText.setText("");
    }
}
