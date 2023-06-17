package com.example.shuruat1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    private DatabaseReference reference;
    private boolean isPasswordVisible = false;
    private FirebaseAuth mAuth;

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
                        && !contact.isEmpty() && !adhaar.isEmpty() && !educationalInstitute.isEmpty() && !password.isEmpty() && isContactValid(contact)) {

                    if (password.length() >= 6) {
                        mAuth = FirebaseAuth.getInstance();

                        mAuth.createUserWithEmailAndPassword(emailId, password)

                                .addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            // Registration success, send verification email
                                            sendVerificationEmail();
                                            saveUserToDatabase(name, emailId, contact, adhaar, educationalInstitute);
                                            clearFields();
                                            User user = new User(name, emailId, contact, adhaar, educationalInstitute, password);
                                            reference = FirebaseDatabase.getInstance().getReference().child("Registration");
                                            reference.push().setValue(user);
                                            Toast.makeText(register.this, "Registration Successful. Please check your email for verification.", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(register.this, Login.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(register.this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    } else {
                        Toast.makeText(register.this, "Password should be at least 6 characters long", Toast.LENGTH_SHORT).show();
                    }
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

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CheckBox passwordVisibilityCheckbox = findViewById(R.id.eye);
        passwordVisibilityCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                isPasswordVisible = isChecked;
                if (isChecked) {
                    passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                passwordEditText.setSelection(passwordEditText.getText().length());
            }
        });
    }

    private void sendVerificationEmail() {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(register.this, "Verification email sent. Please check your email.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(register.this, "Failed to send verification email.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void saveUserToDatabase(String name, String email, String contact, String adhaar, String educationalInstitute) {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            String userId = user.getUid();
            reference = FirebaseDatabase.getInstance().getReference().child("Registration").child(userId);
            User userData = new User(name, email, contact, adhaar, educationalInstitute);
            reference.setValue(userData);
        }
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

    private boolean isContactValid(String contact) {
        // Pattern to match a valid contact number (10 digits)
        String contactPattern = "[0-9]{10}";
        return contact.matches(contactPattern);
    }
}
