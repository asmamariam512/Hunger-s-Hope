package com.example.windows.foodish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FindPageActivity extends AppCompatActivity {
private Button btn;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_page);
        btn= (Button) findViewById(R.id.buttoncofirm) ;
        final Intent in = new Intent(this , MainActivity.class);
        btn1= (Button) findViewById(R.id.mapbutton) ;
        final Intent in1 = new Intent(this , MapsActivity.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(in);



            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(in1);



            }
        });
    }
}
