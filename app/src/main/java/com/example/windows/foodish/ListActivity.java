package com.example.windows.foodish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    ListView listViewDonors;
    DatabaseReference databaseArtists;
    List<Donor>donorList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listViewDonors = (ListView) findViewById(R.id.listViewDonors);
        donorList=new ArrayList<>();
        databaseArtists = FirebaseDatabase.getInstance().getReference("Donors");

    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                donorList.clear();
                //change hole
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    //getting artist
                    Donor temp = snapshot.getValue(Donor.class);

                    //adding artist to the list
                    donorList.add(temp);

                }




                //creating adapter
                DonorList Adapter = new DonorList(ListActivity.this, donorList);
                //attaching adapter to the listview
                listViewDonors.setAdapter(Adapter);


            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                //error hole

            }
        });
    }
}
