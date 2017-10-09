package com.example.windows.foodish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DonationActivity extends AppCompatActivity {
    DatabaseReference databaseDonation;
    ListView donationlist;
    List<Donation> DonationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = auth.getCurrentUser();
        final String uid = firebaseUser.getUid();
        donationlist= (ListView) findViewById(R.id.donationlist);
        DonationList=new ArrayList<>();
        databaseDonation= FirebaseDatabase.getInstance().getReference("Donations");
        databaseDonation.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DonationList.clear();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    Donation temp = snapshot.getValue(Donation.class);
                    if(temp.getDuid().equals(uid))
                    {
                        DonationList.add(temp);

                    }

                    //adding artist to the list

                }
                DonationList Adapter = new DonationList(DonationActivity.this, DonationList);
                //attaching adapter to the listview
                donationlist.setAdapter(Adapter);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });






    }
}
