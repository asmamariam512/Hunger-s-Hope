package com.example.windows.foodish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListActivity3 extends AppCompatActivity {
    ListView listviewfree;
   // DatabaseReference databaseArtists;
    List<rInfo> HungerList2;

    DatabaseReference databaseReceiver;
    String area,people;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list4);
        databaseReceiver = FirebaseDatabase.getInstance().getReference("Receivers");
        listviewfree = (ListView) findViewById(R.id.listviewfree);
        HungerList2=new ArrayList<>();
        Intent j = getIntent();
         area = j.getStringExtra("area");
         people=j.getStringExtra("people");
       // Toast toast=Toast.makeText(getApplicationContext(),area,Toast.LENGTH_LONG);
        //toast.show();
        // tx2.setText(val);
        databaseReceiver.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HungerList2.clear();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    rInfo temp = snapshot.getValue(rInfo.class);
                    if(temp.getRadd().equals(area)&& Integer.parseInt(temp.getRpeople()) <= Integer.parseInt(people))
                    {
                        HungerList2.add(temp);
                    }

                    //adding artist to the list

                }
                HungerList2 Adapter = new HungerList2(ListActivity3.this, HungerList2);
                //attaching adapter to the listview
                listviewfree.setAdapter(Adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
