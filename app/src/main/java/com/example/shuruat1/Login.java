package com.example.shuruat1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
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

public class Login extends AppCompatActivity {
    EditText loginUsername, loginPassword;
    Button loginButton;
    CheckBox passwordVisibilityCheckbox;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        loginUsername = findViewById(R.id.editTextTextPersonName);
        loginPassword = findViewById(R.id.editTextTextPassword2);
        loginButton = findViewById(R.id.button);
        passwordVisibilityCheckbox = findViewById(R.id.eye2);

        mAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validUsername() && validPassword()) {
                    loginUser();
                }
            }
        });

        passwordVisibilityCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // Show password
                    loginPassword.setTransformationMethod(null);
                } else {
                    // Hide password
                    loginPassword.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

        TextView btn = findViewById(R.id.sign_up);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, register.class));
            }
        });
    }

    public Boolean validUsername() {
        String val = loginUsername.getText().toString().trim();
        if (val.isEmpty()) {
            loginUsername.setError("Username cannot be empty");
            return false;
        } else {
            loginUsername.setError(null);
            return true;
        }
    }

    public Boolean validPassword() {
        String val = loginPassword.getText().toString().trim();
        if (val.isEmpty()) {
            loginPassword.setError("Password cannot be empty");
            return false;
        } else if (val.length() < 6) {
            loginPassword.setError("Password must be at least 6 characters");
            return false;
        } else {
            loginPassword.setError(null);
            return true;
        }
    }

    public void loginUser() {
        String userUsername = loginUsername.getText().toString().trim();
        String userPassword = loginPassword.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(userUsername, userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                if (user.isEmailVerified()) {
                                    // User is logged in and email is verified
                                    loginUsername.setError(null);
                                    Intent intent = new Intent(Login.this, homepage.class);
                                    startActivity(intent);
                                } else {
                                    // User email is not verified
                                    Toast.makeText(Login.this, "Please verify your email to login.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        } else {
                            // Login failed
                            loginPassword.setError("Invalid Credentials");
                            loginPassword.requestFocus();
                        }
                    }
                });
    }
}
