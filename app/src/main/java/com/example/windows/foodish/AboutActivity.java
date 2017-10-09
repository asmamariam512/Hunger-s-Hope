package com.example.windows.foodish;


        import android.content.Context;
        import android.content.Intent;
        import android.hardware.Sensor;
        import android.hardware.SensorEvent;
        import android.hardware.SensorEventListener;
        import android.hardware.SensorManager;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1;

    private Button btn2;
    private Button btn5;
    private SensorManager sm;
    private float accelVal;
    private float accelLast;
    private float shake;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        btn1 = (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.button3);

        btn2.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.button5);

        btn5.setOnClickListener(this);
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
                startActivity(new Intent(AboutActivity.this, MainActivity.class));
               // Toast toast=Toast.makeText(getApplicationContext(),"Asma Mariam",Toast.LENGTH_LONG);
               // toast.show();

            }






        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    @Override
    public void onClick(View view) {
        if (view == btn1){

            startActivity(new Intent(AboutActivity.this, Gallery.class));
        }
        if (view == btn2){

            startActivity(new Intent(AboutActivity.this, Gallery1.class));
        }
        if (view == btn5){

            startActivity(new Intent(AboutActivity.this, ListActivity.class));
        }


    }
    public void onBackPressed(){

        startActivity(new Intent(AboutActivity.this, MainActivity.class)); ///can manupulate the back button

    }
}



