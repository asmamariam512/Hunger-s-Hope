package com.example.windows.foodish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.widget.Toast.LENGTH_SHORT;

public class Confirm_Activity extends AppCompatActivity {
    String val,Aa,uid;
    EditText a;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_);
        a = (EditText) findViewById(R.id.editText7);
        btn = (Button) findViewById(R.id.button8) ;
        Aa=a.getText().toString();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = auth.getCurrentUser();
         uid = firebaseUser.getUid();
        Intent j = getIntent();
         val = j.getStringExtra("receivername");
        final Intent in = new Intent(this , MsgActivity.class);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast toast=Toast.makeText(getApplicationContext(),Aa,Toast.LENGTH_LONG);
                toast.show();
                //String val1 = j.getStringExtra("receivername");





            }
        });

    }
}
