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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.widget.Toast.LENGTH_SHORT;

public class FreeDonationActivity extends AppCompatActivity {
    private Button btn4;
    private EditText a;
    private EditText b;
    private EditText c,d,e;
    String name,address,num;
    String area,people;
    DatabaseReference freen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_donation);
        a=(EditText) findViewById(R.id.editText);
        b=(EditText) findViewById(R.id.editText2);
        c=(EditText) findViewById(R.id.editText3);
        d=(EditText) findViewById(R.id.editText4);
        e=(EditText) findViewById(R.id.editText5);
        freen = FirebaseDatabase.getInstance().getReference("FreeDonor");


        btn4= (Button) findViewById(R.id.button4) ;

        final Intent in4 = new Intent(this , ListActivity3.class);


            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    name=a.getText().toString().trim();
                    address=b.getText().toString().trim();
                    num=c.getText().toString().trim();
                    area=d.getText().toString().toLowerCase().trim();
                    people=e.getText().toString().trim();
                    if (TextUtils.isEmpty(name)){
                        Toast toast = Toast.makeText(getApplicationContext(),"Enter Name!" , LENGTH_SHORT);
                        toast.show();
                       // x=1;

                        return;
                    }
                    if (TextUtils.isEmpty(address)){
                        Toast toast = Toast.makeText(getApplicationContext(),"Enter Address!" , LENGTH_SHORT);
                        toast.show();
                       // x=1;

                        return;
                    }
                    if (TextUtils.isEmpty(num)){
                        Toast toast = Toast.makeText(getApplicationContext(),"Enter Number Of People!!" , LENGTH_SHORT);
                        toast.show();
                       // x=1;

                        return;
                    }
                    else
                    {
                        String id1= freen.push().getKey();


            DonateWithoutReg don=new DonateWithoutReg(name,address,num);


                        freen.child(id1).setValue(don);
                        in4.putExtra("area",area);
                        in4.putExtra("people",people);
                        //Toast.makeText(this, "Informations Added", Toast.LENGTH_LONG).show()
                        startActivity(in4);
                    }









                }
            });






    }
}
