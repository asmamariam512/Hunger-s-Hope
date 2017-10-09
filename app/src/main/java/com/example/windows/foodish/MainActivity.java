package com.example.windows.foodish;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button btn3;
    Button btn;
    Button btn4;
    Button bttn2;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn3= (Button) findViewById(R.id.button3) ;
        btn= (Button) findViewById(R.id.edit) ;
        btn4= (Button) findViewById(R.id.button4) ;
        bttn2=(Button) findViewById(R.id.button2) ;


        final Intent in3 = new Intent(this , Main2Activity.class);
        final Intent in = new Intent(this , SignInActivity.class);
        final Intent in4= new Intent(this , AboutActivity.class);
        final Intent in2=new Intent(this, RSignIn.class);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(in3);



            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(in);



            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(in4);



            }
        });
        bttn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(in2);
            }
        });


        viewPager=(ViewPager)findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new myTimerTask(),2000,4000);

    }
    public class myTimerTask extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);


                    } else if(viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                    }
                    else if(viewPager.getCurrentItem()==2){
                        viewPager.setCurrentItem(3);}
                        else if(viewPager.getCurrentItem()==3){
                            viewPager.setCurrentItem(4);}
                    else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });

        }
    }
    public void onBackPressed(){

        startActivity(new Intent(MainActivity.this, MainActivity.class)); ///can manupulate the back button

    }
}
