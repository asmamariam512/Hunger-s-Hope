package com.example.windows.foodish;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RSignIn extends AppCompatActivity implements View.OnClickListener{

    private Button rLogIn;
    private EditText rEmailField;
    private EditText rPasswordField;
    private TextView rSignup;

    private ProgressDialog progressDialog;

    // defining FirebaseAuth
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsign_in);

        firebaseAuth = FirebaseAuth.getInstance();

        //if someone is already logged in
        if (firebaseAuth.getCurrentUser() != null){
            finish(); // then close this activity
            startActivity(new Intent(RSignIn.this, rEditProfile.class)); // and go to their profile page
        }

        //initializing all the views
        rEmailField = (EditText) findViewById(R.id.rEmailField);
        rPasswordField = (EditText) findViewById(R.id.rPasswordField);

        rLogIn = (Button) findViewById(R.id.rLogIn);
        rSignup = (TextView) findViewById(R.id.rSignup);

        progressDialog = new ProgressDialog(this);

        rLogIn.setOnClickListener(this);

        rSignup.setOnClickListener(this);
    }
    public void onBackPressed(){

        startActivity(new Intent(RSignIn.this, MainActivity.class)); ///can manupulate the back button

    }
    int x=0;

    @Override
    public void onClick(View view) {

        if (view == rLogIn){
            // Toast.makeText(this, "Please enter email!", Toast.LENGTH_SHORT).show();
            if(x==0)
            userLogin();
            else
                startActivity(new Intent(RSignIn.this, RSignIn.class));
        }
        if (view == rSignup){
            //Toast.makeText(this, "Please enter email!", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(RSignIn.this, RSignUp.class));
        }

    }

    private void userLogin() {

        //getting all the inputs from the user
        String email = rEmailField.getText().toString().trim();
        String password = rPasswordField.getText().toString().trim();

        //validation
        if (TextUtils.isEmpty(email)){
            x=1;
            Toast.makeText(this, "Please enter email!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            x=1;
            Toast.makeText(this, "Please enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() <= 5){
            x=1;
            Toast.makeText(this, "Password must be more than 5 characters!", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Signing in, Please Wait...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            finish();
                            progressDialog.hide();

                            startActivity(new Intent(getApplicationContext(), rEditProfile.class));
                        } else {
                            Toast.makeText(RSignIn.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                            progressDialog.hide();
                        }
                    }
                });

    }
}
