package com.example.windows.foodish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class DonorSignUp extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextdEmail;
    private EditText dPassword;
    private EditText cPassword;
    private TextView textViewAddD;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();

        editTextdEmail = (EditText) findViewById(R.id.editTextdEmail);
        dPassword = (EditText) findViewById(R.id.dPassword);
        cPassword = (EditText) findViewById(R.id.cPassword);

        textViewAddD = (TextView) findViewById(R.id.textViewAddD);

        progressDialog = new ProgressDialog(this);

        textViewAddD.setOnClickListener(this);
    }
    int x=0;
    int f=0;

    @Override
    public void onClick(View view) {

        if(view == textViewAddD){
            registerUser();
            if(x!=1 && f==1 )

            startActivity(new Intent(DonorSignUp.this, DonorMore.class));
            else
                startActivity(new Intent(DonorSignUp.this, DonorSignUp.class));


        }

    }

    private void registerUser() {




        String email = editTextdEmail.getText().toString().trim();
        final String password = dPassword.getText().toString().trim();
        final String cpassword = cPassword.getText().toString().trim();
        if(password.equals(cpassword))
        {
            f=1;
        }
        // String phone = editTextPhone.getText().toString().trim();
        if (TextUtils.isEmpty(email)){
            x=1;
            Toast.makeText(this, "Please enter email!", Toast.LENGTH_SHORT).show();
          //  startActivity(new Intent(DonorSignUp.this, DonorSignUp.class));
            return;
        }

        //  Toast.makeText(this, "5555", Toast.LENGTH_SHORT).show();



        if (TextUtils.isEmpty(password)){
            x=1;
            Toast.makeText(this, "Please enter password!", Toast.LENGTH_SHORT).show();
           // startActivity(new Intent(DonorSignUp.this, DonorSignUp.class));
            return;
        }
        if (password.length() <= 5){
            x=1;
          //  startActivity(new Intent(DonorSignUp.this, DonorSignUp.class));
            Toast.makeText(this, "Password must be more than 5 characters!", Toast.LENGTH_SHORT).show();

            return;
        }
        progressDialog.setMessage("Registering, Please Wait...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            if(password.equals(cpassword)) {
                                Toast.makeText(DonorSignUp.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                                progressDialog.hide();
                                startActivity(new Intent(DonorSignUp.this, DonorMore.class));
                            }

                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(DonorSignUp.this, "Email already exists!", Toast.LENGTH_SHORT).show();
                                progressDialog.hide();
                                return;
                            }
                            Toast.makeText(DonorSignUp.this, "Something went terrible wrong!", Toast.LENGTH_SHORT).show();
                            progressDialog.hide();
                            return;
                        }
                    }
                });}
}
