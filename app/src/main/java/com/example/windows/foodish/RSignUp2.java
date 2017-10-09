package com.example.windows.foodish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.widget.Toast.LENGTH_SHORT;

public class RSignUp2 extends AppCompatActivity {

    private EditText editTextrName;
    private EditText rAddress;
    private EditText rPhone1;
    private EditText rId;
    private EditText rPeople;
    private EditText rPhone;
    private Button rSignUp;
    private Spinner spinner3;
    public String asmi;

    DatabaseReference databaseReceiver;

    int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsign_up2);

        databaseReceiver = FirebaseDatabase.getInstance().getReference("Receivers");


        editTextrName=(EditText) findViewById(R.id.editTextrName);
        rAddress=(EditText) findViewById(R.id.rAddress);
        rPeople=(EditText) findViewById(R.id.rPeople);
        rPhone=(EditText) findViewById(R.id.rPhone);
        rPhone1=(EditText) findViewById(R.id.rPhone1);
        rId=(EditText) findViewById(R.id.rId);
        rSignUp=(Button) findViewById(R.id.rSignUp);
        spinner3=(Spinner) findViewById(R.id.spinner3);


        rSignUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                if(view == rSignUp){
                    AddInfo();
                    if(x==0)

                    startActivity(new Intent(RSignUp2.this, rEditProfile.class));
                    else
                        startActivity(new Intent(RSignUp2.this, RSignUp2.class));

                }


            }
        });
    }
    private void AddInfo(){
        String name=editTextrName.getText().toString().trim();
        String address=rAddress.getText().toString().toLowerCase().trim();
        String people=rPeople.getText().toString().trim();
        String phone=rPhone.getText().toString().trim();
        String phone1=rPhone1.getText().toString().trim();
        String rId1=rId.getText().toString().trim();
        String type=spinner3.getSelectedItem().toString();


        if (TextUtils.isEmpty(name)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter Name!" , LENGTH_SHORT);
            toast.show();
            x=1;

            return;
        }
        if (TextUtils.isEmpty(address)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter Address!" , LENGTH_SHORT);
            toast.show();
            x=1;

            return;
        }
        if (TextUtils.isEmpty(people)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter Number Of People!!" , LENGTH_SHORT);
            toast.show();
            x=1;

            return;
        }
        if (TextUtils.isEmpty(phone)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter Phone Number!!" , LENGTH_SHORT);
            toast.show();
            x=1;

            return;
        }
        if (TextUtils.isEmpty(phone1)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter Phone Number!!" , LENGTH_SHORT);
            toast.show();
            x=1;

            return;
        }
        if (TextUtils.isEmpty(rId1)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter National Id Number!!" , LENGTH_SHORT);
            toast.show();
            x=1;

            return;
        }




        else
        {
            String id= databaseReceiver.push().getKey();
            FirebaseAuth auth = FirebaseAuth.getInstance();
            FirebaseUser firebaseUser = auth.getCurrentUser();
          String   uid = firebaseUser.getUid();
            String duid= "";



            rInfo info=new rInfo(name,address,people,phone,id,type,uid,duid,phone1,rId1);


            databaseReceiver.child(id).setValue(info);
            Toast.makeText(this, "Informations Added", Toast.LENGTH_LONG).show();


        }
    }
    public void onBackPressed(){

        startActivity(new Intent(RSignUp2.this, RSignUp2.class)); ///can manupulate the back button

    }
}
