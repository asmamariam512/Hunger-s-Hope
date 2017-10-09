package com.example.windows.foodish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class MsgActivity extends AppCompatActivity {

    Button btn;
    ListView listViewHungers;
    DatabaseReference databaseArtists;
    List<rInfo> HungerList;
    String jakepathabotarnam;
    DatabaseReference databaseReceiver;
    String uid;
    int k=0;
    TextView msg;
 String asmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);
        databaseReceiver = FirebaseDatabase.getInstance().getReference("Receivers");
        databaseArtists = FirebaseDatabase.getInstance().getReference("Donors");
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = auth.getCurrentUser();
         uid = firebaseUser.getUid();
       // Toast toast2=Toast.makeText(getApplicationContext(),uid,Toast.LENGTH_LONG);
        //toast2.show();


               msg=(TextView)findViewById(R.id.textView18);





                databaseReceiver.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                            //getting artist
                            rInfo temp = snapshot.getValue(rInfo.class);
                            final String dibe=temp.getDuid();
                            databaseArtists.addValueEventListener(new ValueEventListener() {


                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                                        Donor d=snapshot.getValue(Donor.class);
                                        if(d.getUid().equals(dibe))
                                        {
                                           // Toast toast2=Toast.makeText(getApplicationContext(),d.getDname(),Toast.LENGTH_LONG);
                                            //toast2.show();
                                            asmi=d.getDname();
                                            msg.setText(asmi + " wants to donate you Food!!");
                                        }

                                        //adding artist to the list

                                    }


                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });





                            //adding artist to the list

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });














    }
}
