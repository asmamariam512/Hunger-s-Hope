package com.example.windows.foodish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class rEditProfile extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    private Button button3;
    private Button button2;
    private FirebaseAuth firebaseAuthh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_edit_profile);

        firebaseAuthh = FirebaseAuth.getInstance();


       button=(Button) findViewById(R.id.edit);
        button3=(Button) findViewById(R.id.button3);
        button2=(Button) findViewById(R.id.imageButton4);

        button.setOnClickListener(this);
        button3.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view==button){
            startActivity(new Intent(rEditProfile.this, EditInfo.class));
        }

        if (view == button3){
            firebaseAuthh.signOut();
            startActivity(new Intent(rEditProfile.this, MainActivity.class));
        }

        if (view == button2){
           // firebaseAuthh.signOut();
            startActivity(new Intent(rEditProfile.this, MsgActivity.class));
        }

    }
    public void onBackPressed(){

        startActivity(new Intent(rEditProfile.this, MainActivity.class)); ///can manupulate the back button

    }
}
