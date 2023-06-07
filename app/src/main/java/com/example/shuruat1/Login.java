package com.example.shuruat1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Login extends AppCompatActivity {
    EditText loginUsername , loginPassword;
    Button loginButton;
    public void login(View view){
        Toast.makeText(this, "LOGIN SUCCESSFULLY", Toast.LENGTH_SHORT).show();
    }
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        loginUsername=findViewById(R.id.editTextTextPersonName);
        loginPassword = findViewById(R.id.editTextTextPassword2);
        loginButton=findViewById(R.id.button);

loginButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (!validUsername() | !validPassword()){

        }else {
            checkUser();
        }
    }
});








        TextView btn=findViewById(R.id.sign_up);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,register.class));

            }
        });
    }

public  Boolean validUsername(){
        String val = loginUsername.getText().toString();
        if(val.isEmpty()){
            loginUsername.setError("Username cannot be empty");
            return false;
        }else {
            loginUsername.setError(null);
            return true;
        }
}


    public  Boolean validPassword(){
        String val = loginPassword.getText().toString();
        if(val.isEmpty()){
            loginPassword.setError("Password cannot be empty");
            return false;
        }else {
            loginPassword.setError(null);
            return true;
        }
    }
    public void checkUser() {
        String userUsername = loginUsername.getText().toString().trim();
        String userPassword = loginPassword.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Registration");
        Query checkUserDatabase = reference.orderByChild("email_id").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                        User user = userSnapshot.getValue(User.class);
                        if (user != null) {
                            String passwordFromDB = user.getPassword();
                            if (passwordFromDB.equals(userPassword)) {
                                loginUsername.setError(null);
                                Intent intent = new Intent(Login.this, homepage.class);
                                startActivity(intent);
                                return;
                            }
                        }
                    }
                    loginPassword.setError("Invalid Credentials");
                    loginPassword.requestFocus();
                } else {
                    loginUsername.setError("User does not exist");
                    loginUsername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled event
            }
        });
    }
}