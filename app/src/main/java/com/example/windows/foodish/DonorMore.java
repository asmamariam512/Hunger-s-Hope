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

public class DonorMore extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextAddress;
    private EditText editTextCity;
    private EditText editTextRoad;
    private EditText editTextPostal;
    private EditText editTextDustrict;
    private EditText editTextManName;
    private EditText editTextManPhone;
    private EditText editTextId;
    private EditText editTextPhone;

    private Spinner spinner;
    private Button buttonSignup2;
    DatabaseReference databaseArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_more);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextCity = (EditText) findViewById(R.id.editTextCity);
        editTextPhone= (EditText) findViewById(R.id.editTextPhone);

        editTextRoad= (EditText) findViewById(R.id.editTextRoad);
        editTextPostal= (EditText) findViewById(R.id.editTextPostal);
        editTextDustrict= (EditText) findViewById(R.id.editTextDustrict);
        editTextManName= (EditText) findViewById(R.id.editTextManName);
        editTextManPhone= (EditText) findViewById(R.id.editTextManPhone);
        editTextId= (EditText) findViewById(R.id.editTextId);


        spinner = (Spinner) findViewById(R.id.spinner);
        databaseArtists = FirebaseDatabase.getInstance().getReference("Donors");


        buttonSignup2 = (Button) findViewById(R.id.buttonSignup2);
        buttonSignup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addArtist1();

            }
        });
    }
    private void addArtist1() {
        final Intent in = new Intent(this , SignInActivity.class);
        //getting the values to save
        String name = editTextName.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String city = editTextCity.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String road = editTextRoad.getText().toString().trim();
        String postal = editTextPostal.getText().toString().trim();
        String district = editTextDustrict.getText().toString().trim();
        String manname = editTextManName.getText().toString().trim();
        String manphone = editTextManPhone.getText().toString().trim();
        String nationalid = editTextId.getText().toString().trim();
        String s= spinner.getSelectedItem().toString();





        //checking if the value is provided

        if (TextUtils.isEmpty(name)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter Name!" , LENGTH_SHORT);
            toast.show();

            return;
        }
        if (TextUtils.isEmpty(address)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter House No!" , LENGTH_SHORT);
            toast.show();

            return;
        }
        if (TextUtils.isEmpty(road)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter Road!" , LENGTH_SHORT);
            toast.show();

            return;
        }
        if (TextUtils.isEmpty(postal)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter Postal Code!" , LENGTH_SHORT);
            toast.show();

            return;
        }

        if (TextUtils.isEmpty(city)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter City!" , LENGTH_SHORT);
            toast.show();

            return;
        }
        if (TextUtils.isEmpty(district)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter District!" , LENGTH_SHORT);
            toast.show();

            return;
        }
        if (TextUtils.isEmpty(phone)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter Phone!" , LENGTH_SHORT);
            toast.show();

            return;
        }





        if (TextUtils.isEmpty(manname)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter Manager Name!" , LENGTH_SHORT);
            toast.show();

            return;
        }

        if (TextUtils.isEmpty(manphone)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter Manager Phone!" , LENGTH_SHORT);
            toast.show();

            return;
        }

        if (TextUtils.isEmpty(nationalid)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter National Id!" , LENGTH_SHORT);
            toast.show();

            return;
        }





        else {
            //if the value is not given displaying a toast
            String id = databaseArtists.push().getKey();
            FirebaseAuth auth = FirebaseAuth.getInstance();
            FirebaseUser firebaseUser = auth.getCurrentUser();
            String uid = firebaseUser.getUid();

            //creating an Artist Object
            Donor donor = new Donor(name,address,city,phone,s,id,uid,road,postal,district,manname,manphone,nationalid);

            //Saving the Artist
            databaseArtists.child(id).setValue(donor);

            //setting edittext to blank again


            //displaying a success toast
            Toast.makeText(this, "Donor added", Toast.LENGTH_LONG).show();
            startActivity(in);
        }
    }
    public void onBackPressed(){

        startActivity(new Intent(DonorMore.this, DonorMore.class)); ///can manupulate the back button

    }

}
