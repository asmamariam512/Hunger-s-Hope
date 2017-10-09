package com.example.windows.foodish;

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
import com.google.firebase.auth.FirebaseUser;

public class RSignUp extends AppCompatActivity implements View.OnClickListener{
    private EditText editTextrEmail;
    private EditText rPassword;
    private EditText rConfirmPassword;
    private TextView textViewAdd;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsign_up);

        firebaseAuth = FirebaseAuth.getInstance();

        editTextrEmail = (EditText) findViewById(R.id.editTextrEmail);
        rPassword = (EditText) findViewById(R.id.rPassword);
        rConfirmPassword = (EditText) findViewById(R.id.rConfirmPassword);

        textViewAdd = (TextView) findViewById(R.id.textViewAdd);

        progressDialog = new ProgressDialog(this);

        textViewAdd.setOnClickListener(this);
    }
    int x=0;
    int f=0;

    @Override
    public void onClick(View view) {
        if(view == textViewAdd){
            registerUser();


            if(x==0 && f==1) {



                startActivity(new Intent(RSignUp.this,RSignUp2.class));
            }
            else
            startActivity(new Intent(RSignUp.this, RSignUp.class));


        }
    }


    private void registerUser() {




        String email = editTextrEmail.getText().toString().trim();
        final String password = rPassword.getText().toString().trim();
        final String cpassword = rConfirmPassword.getText().toString().trim();
        if(password.equals(cpassword))
        {
            f=1;
        }
        // String phone = editTextPhone.getText().toString().trim();
        if (TextUtils.isEmpty(email)){
            x=1;
            Toast.makeText(this, "Please enter email!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RSignUp.this, RSignUp.class));
            return;
        }

        //  Toast.makeText(this, "5555", Toast.LENGTH_SHORT).show();



        if (TextUtils.isEmpty(password)){
            x=1;
            Toast.makeText(this, "Please enter password!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RSignUp.this, RSignUp.class));
            return;
        }
        if (password.length() <= 5){
            x=1;
            Toast.makeText(this, "Password must be more than 5 characters!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RSignUp.this, RSignUp.class));
            return;
        }
        progressDialog.setMessage("Registering, Please Wait...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            if(f==1)


                            {
                                Toast.makeText(RSignUp.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                                progressDialog.hide();
                                startActivity(new Intent(RSignUp.this, RSignUp2.class));
                            }

                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(RSignUp.this, "Email already exists!", Toast.LENGTH_SHORT).show();
                                progressDialog.hide();
                                return;
                            }
                            Toast.makeText(RSignUp.this, "Something went terrible wrong!", Toast.LENGTH_SHORT).show();
                            progressDialog.hide();
                            return;
                        }
                    }
                });}
}
