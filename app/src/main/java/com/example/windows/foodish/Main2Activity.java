
package com.example.windows.foodish;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.widget.Toast.LENGTH_SHORT;

public class Main2Activity extends AppCompatActivity  {
    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private Button button5;
    DatabaseReference databaseArtists;
    private SensorManager sm;
    private float accelVal;
    private float accelLast;
    private float shake;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        databaseArtists = FirebaseDatabase.getInstance().getReference("Volunteers");

        button5 = (Button) findViewById(R.id.button5);



        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addArtist();




            }
        });
        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener,sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
        accelVal=SensorManager.GRAVITY_EARTH;
        accelLast=SensorManager.GRAVITY_EARTH;
        shake=0.00f;
    }
    private  final SensorEventListener sensorListener =new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x=sensorEvent.values[0];
            float y=sensorEvent.values[1];
            float z=sensorEvent.values[2];
            accelLast=accelVal;
            accelVal=(float) Math.sqrt((double)(x*x+y*y+z*z));
            float delta=accelVal-accelLast;
            shake=shake*0.9f+delta;


            if(shake>12)
            {
                // Toast.makeText(this, "Volunteer added", Toast.LENGTH_LONG).show();

                // startActivity(asmi);
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
                //Toast toast=Toast.makeText(getApplicationContext(),"Asma Mariam",Toast.LENGTH_LONG);
                //toast.show();

            }






        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    private void addArtist() {
        final Intent in = new Intent(this , MainActivity.class);
        //getting the values to save
        String name = editText.getText().toString().trim();
        String address = editText2.getText().toString().trim();
        String email = editText3.getText().toString().trim();
        String phone = editText4.getText().toString().trim();
        String aval = editText5.getText().toString().trim();





        //checking if the value is provided

        if (TextUtils.isEmpty(name)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter Name!" , LENGTH_SHORT);
            toast.show();

            return;
        }
        if (TextUtils.isEmpty(address)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter Address!" , LENGTH_SHORT);
            toast.show();

            return;
        }
        if (TextUtils.isEmpty(email)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter Email!" , LENGTH_SHORT);
            toast.show();

            return;
        }
        if (TextUtils.isEmpty(phone)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter Phone!" , LENGTH_SHORT);
            toast.show();

            return;
        }
        if (TextUtils.isEmpty(aval)){
            Toast toast = Toast.makeText(getApplicationContext(),"Enter Availability!" , LENGTH_SHORT);
            toast.show();

            return;
        }


        else {
            //if the value is not given displaying a toast
            String id = databaseArtists.push().getKey();

            //creating an Artist Object
            Volunteer artist = new Volunteer(id, name,address,phone,email,aval);

            //Saving the Artist
            databaseArtists.child(id).setValue(artist);

            //setting edittext to blank again


            //displaying a success toast
            Toast.makeText(this, "Volunteer added", Toast.LENGTH_LONG).show();
            startActivity(in);
        }
    }


}
