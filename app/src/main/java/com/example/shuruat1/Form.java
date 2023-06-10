package com.example.shuruat1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;

public class Form extends AppCompatActivity {
    private EditText nameEditText;
    private EditText dobEditText;
    private EditText genderEditText;
    private EditText contactEditText;
    private EditText emailEditText;
    private EditText aadhaarEditText;
    private EditText FatherEditText;
    private EditText EducationEditText;
    private EditText EnrolmentEditText;
    private EditText YearEditText;
    private EditText IncomeEditText;
    private EditText ExpensesEditText;
    private EditText fatherEditText;
    private EditText motherEditText;
    private EditText ScholarEditText;
    private EditText FinancialEditText;
    EditText etDate;
    DatePickerDialog.OnDateSetListener setListener;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();

        nameEditText = findViewById(R.id.editTextTextPersonName5);
        dobEditText = findViewById(R.id.date);
        genderEditText = findViewById(R.id.editTextTextPersonName2);
        contactEditText = findViewById(R.id.editTextPhone2);
        emailEditText = findViewById(R.id.editTextTextEmailAddress2);

        aadhaarEditText = findViewById(R.id.editTextNumber);
        FatherEditText = findViewById(R.id.editTextTextPersonName4);
        EducationEditText = findViewById(R.id.editTextTextPersonName6);
        EnrolmentEditText = findViewById(R.id.editTextNumber2);
        YearEditText = findViewById(R.id.editTextTextPersonName7);
        IncomeEditText = findViewById(R.id.editTextTextPersonName8);
        ExpensesEditText = findViewById(R.id.editTextTextPersonName9);
        fatherEditText = findViewById(R.id.editTextTextPersonName11);
        motherEditText = findViewById(R.id.editTextTextPersonName12);
        ScholarEditText = findViewById(R.id.editTextTextMultiLine);
        FinancialEditText = findViewById(R.id.editTextTextMultiLine2);

        findViewById(R.id.Applications).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String dob = dobEditText.getText().toString();
                String gender = genderEditText.getText().toString();
                String contact = contactEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String aadhaar = aadhaarEditText.getText().toString();
                String father = fatherEditText.getText().toString();
                String education = EducationEditText.getText().toString();
                String Roll = EnrolmentEditText.getText().toString();
                String year = YearEditText.getText().toString();
                String income = IncomeEditText.getText().toString();
                String expenses = ExpensesEditText.getText().toString();
                String father_occ = fatherEditText.getText().toString();
                String mother_occ = motherEditText.getText().toString();
                String scholor = ScholarEditText.getText().toString();
                String assiatnace = FinancialEditText.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(Form.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (dob.isEmpty()) {
                    Toast.makeText(Form.this, "Please enter your Date of Birth", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (gender.isEmpty()) {
                    Toast.makeText(Form.this, "Please enter your Gender", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (aadhaar.isEmpty()) {
                    Toast.makeText(Form.this, "Please enter your Aadhaar number", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (father.isEmpty()) {
                    Toast.makeText(Form.this, "Please enter your Father Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (education.isEmpty()) {
                    Toast.makeText(Form.this, "Please enter your Educational institute", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Roll.isEmpty()) {
                    Toast.makeText(Form.this, "Please enter your Enrollment Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (income.isEmpty()) {
                    Toast.makeText(Form.this, "Please enter your Family Income", Toast.LENGTH_SHORT).show();
                    return;
                }
//if (name.isEmpty() && dob.isEmpty() && gender.isEmpty() && aadhaar.isEmpty() && father.isEmpty() && education.isEmpty() && Roll.isEmpty() && income.isEmpty()){
//    Toast.makeText(Form.this, "Please fill all the fields correctly", Toast.LENGTH_SHORT).show();
//}

                if (isEmailValid(email) && isContactValid(contact)) {
                    HashMap<String, Object> data = new HashMap<>();
                    data.put("name", name);
                    data.put("DOB", dob);
                    data.put("Gender", gender);
                    data.put("Contact", contact);
                    data.put("Email_Id", email);

                    data.put("Aadhaar", aadhaar);
                    data.put("Father Name", father);
                    data.put("Educational Institution", education);
                    data.put("Enrolment Number", Roll);
                    data.put("Year of Study", year);
                    data.put("Family Income", income);
                    data.put("Expenses", expenses);
                    data.put("Father Occupation", father_occ);
                    data.put("Mother Occupation", mother_occ);
                    data.put("Any availed scholarship", scholor);
                    data.put("Need of Scholarship", assiatnace);

                    mAuth.createUserWithEmailAndPassword(email, "password")
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    // Send email verification
                                    sendEmailVerification();
                                    // Save user data in Firestore
                                    saveUserData(data);
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Form.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(Form.this, "Invalid email address or contact number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        etDate = findViewById(R.id.date);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Form.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        etDate.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
    }

    private boolean isEmailValid(CharSequence email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isContactValid(String contact) {
        // Pattern to match a valid contact number (10 digits)
        String contactPattern = "[0-9]{10}";
        return contact.matches(contactPattern);
    }

    private void sendEmailVerification() {
        mAuth.getCurrentUser().sendEmailVerification()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Form.this, "Verification email sent", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Form.this, "Failed to send verification email: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


    private void saveUserData(HashMap<String, Object> data) {
        FirebaseFirestore.getInstance().collection("User")
                .add(data) // Generates a unique document ID for each user
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(Form.this, "Form Submit Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Form.this, homepage.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Form.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}