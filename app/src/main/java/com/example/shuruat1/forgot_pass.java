package com.example.shuruat1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgot_pass extends AppCompatActivity {
    private Button forgetBtn;
    private EditText forgot_email;
    private String email;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();
        forgot_email = findViewById(R.id.forgot_email);
        forgetBtn = findViewById(R.id.forgetBtn);

        forgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }

            private void validateData() {
                email = forgot_email.getText().toString();
                if (email.isEmpty()) {
                    forgot_email.setError("Enter Valid Email Id");
                } else {
                    forgetPass();
                }
            }

            private void forgetPass() {
                if (auth != null) {
                    auth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(forgot_pass.this, "CHECK YOUR EMAIL", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(forgot_pass.this, Login.class));
                                        finish();
                                    } else {
                                        Toast.makeText(forgot_pass.this, "ERROR: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(forgot_pass.this, "Authentication not initialized", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
