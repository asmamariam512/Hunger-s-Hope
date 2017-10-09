package com.example.windows.foodish;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.widget.Toast.LENGTH_SHORT;

public class EditInfo extends AppCompatActivity {
    Button btn;
    private EditText editTextrName;
    private EditText rAddress;
    private EditText rPeople;
    private EditText rPhone;
    private EditText rPhone1;
    private EditText NationalId;
    public String dhukabo;
    DatabaseReference databaseReceiver;

    String id;
    int c=0;
    int f=0;


    private Spinner spinner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        btn = (Button) findViewById(R.id.button2) ;
        editTextrName=(EditText) findViewById(R.id.editInfoName);
        rAddress=(EditText) findViewById(R.id.editInfoAddress);
        rPeople=(EditText) findViewById(R.id.editInfoPeople);
        rPhone=(EditText) findViewById(R.id.editInfoPhone);
        rPhone1=(EditText) findViewById(R.id.editText9);
        NationalId=(EditText)findViewById(R.id.editText10);
        databaseReceiver = FirebaseDatabase.getInstance().getReference("Receivers");
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = auth.getCurrentUser();
        id = firebaseUser.getUid();


       // Toast.makeText(this, id, Toast.LENGTH_LONG).show();
        databaseReceiver.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    //getting artist


                    //adding artist to the list
                    rInfo temp = snapshot.getValue(rInfo.class);
                    if(temp.getUid().equals(id)) {
                        dhukabo=temp.getReceiverId();
                       // Toast toast2=Toast.makeText(getApplicationContext(),temp.getReceiverId(),Toast.LENGTH_LONG);
                        //toast2.show();




                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });







        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(in);

                spinner3=(Spinner) findViewById(R.id.spinner2);
                String name=editTextrName.getText().toString().trim();
                String address=rAddress.getText().toString().trim();
                String people=rPeople.getText().toString().trim();
                String phone=rPhone.getText().toString().trim();
                String phone1=rPhone1.getText().toString().trim();
                String nid=NationalId.getText().toString().trim();
                String type=spinner3.getSelectedItem().toString();
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
                if (TextUtils.isEmpty(people)){
                    Toast toast = Toast.makeText(getApplicationContext(),"Enter Number Of People!!" , LENGTH_SHORT);
                    toast.show();


                    return;
                }
                if (TextUtils.isEmpty(phone)){
                    Toast toast = Toast.makeText(getApplicationContext(),"Enter Phone Number!!" , LENGTH_SHORT);
                    toast.show();


                    return;
                }



                else {

                    update(dhukabo, name, address, people, phone, type,phone1,nid);
                  //  startActivity(new Intent(EditInfo.this, EditInfo.class));





                }






            }
        });
    }

    private boolean update(String id,String name,String address,String people,String phone,String type,String rphone1,String nid)
    {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = auth.getCurrentUser();
        String uid = firebaseUser.getUid();
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Receivers").child(id);
        String ui="";
        rInfo info=new rInfo(name,address,people,phone,id,type,uid,ui,rphone1,nid);
        // databaseReference.setValue(info);
        databaseReference.setValue(info);

        Toast.makeText(this, "Updated Successfully", Toast.LENGTH_LONG).show();



        return  true;


    }
    public void onBackPressed(){

        startActivity(new Intent(EditInfo.this, rEditProfile.class)); ///can manupulate the back button

    }
}
