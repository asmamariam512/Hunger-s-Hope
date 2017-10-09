package com.example.windows.foodish;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;
import static com.example.windows.foodish.R.id.listViewDonors;

public class ListActivity2 extends AppCompatActivity {
    ListView listViewHungers;
    DatabaseReference databaseArtists;
    List<rInfo> HungerList;
    String jakepathabotarnam;
    DatabaseReference databaseReceiver;
    DatabaseReference databaseDonation;
    rInfo r=new rInfo();
    int k=0;
    Button but;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list3);
        databaseReceiver = FirebaseDatabase.getInstance().getReference("Receivers");
        databaseDonation=FirebaseDatabase.getInstance().getReference("Donations");

        listViewHungers = (ListView) findViewById(R.id.listViewHungers);
        but=(Button)findViewById(R.id.button10);
        final Intent in=new Intent(this,MapsActivity.class);
        but.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(in);
            }
        });
        HungerList=new ArrayList<>();
        databaseArtists = FirebaseDatabase.getInstance().getReference("Receivers");
       // databaseReceiver.removeValue();
        listViewHungers.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                rInfo r = HungerList.get(i);
                jakepathabotarnam=r.getRname();
                // Toast toast = Toast.makeText(getApplicationContext(),jakepathabotarnam , LENGTH_SHORT);
                // toast.show();
                // return true;

                showUpdateDeleteDialog();

                return true;
            }
        });

    }

    private void showUpdateDeleteDialog() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = ListActivity2.this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.confirm_dialouge, null);
        //  dialogBuilder.setView(dialogView);
        DialogInterface dialog = null;
        Dialog f = (Dialog) dialog;
        dialogBuilder.setView(dialogView);


       // final EditText Name = (EditText) dialogView.findViewById(R.id.editText6);
        //final Spinner spinnerGenre = (Spinner) dialogView.findViewById(R.id.spinnerGenres);
        final Button confirmbutton= (Button) dialogView.findViewById(R.id.button6);
        //final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDeleteArtist);
       // final String  Aa=Name.getText().toString();

        dialogBuilder.setTitle("Sending Message");
        final AlertDialog b = dialogBuilder.create();
        b.show();

        final Intent in = new Intent(this , MsgActivity.class);


        confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                k=k+1;

                FirebaseAuth auth = FirebaseAuth.getInstance();
                FirebaseUser firebaseUser = auth.getCurrentUser();
                final String uid = firebaseUser.getUid();

               // Toast.makeText(this, "Informations Added", Toast.LENGTH_LONG).show();


                //  Toast toast=Toast.makeText(getApplicationContext(),uid,Toast.LENGTH_LONG);
                // toast.show();
               /* Toast toast1=Toast.makeText(getApplicationContext(),jakepathabotarnam,Toast.LENGTH_LONG);
                toast1.show();
                Toast toast2=Toast.makeText(getApplicationContext(),uid,Toast.LENGTH_LONG);
                toast2.show();*/

                databaseArtists.addValueEventListener(new ValueEventListener() {

                    @Override

                    public void onDataChange(DataSnapshot dataSnapshot) {
                        HungerList.clear();
                        //change hole

                        for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                            //getting artist
                            rInfo temp = snapshot.getValue(rInfo.class);
                            if(temp.getRname().equals(jakepathabotarnam))
                            {
                               // Toast toast2=Toast.makeText(getApplicationContext(),"paisi",Toast.LENGTH_LONG);
                                //toast2.show();

                                r.setDuid(uid);
                                r.setRadd(temp.getRadd());
                                r.setRname(temp.getRname());
                                r.setRpeople(temp.getRpeople());
                                r.setRphone(temp.getRphone());
                                r.setRtype(temp.getRtype());
                                r.setUid(temp.getUid());


                                //String id= databaseReceiver.push().getKey();
                                //temp.setDuid(uid);
                                //databaseReceiver.child(id).setValue(temp);



                            }


                            //adding artist to the list

                        }





                        //creating adapter
                        HungerList Adapter = new HungerList(ListActivity2.this, HungerList);
                        //attaching adapter to the listview
                        listViewHungers.setAdapter(Adapter);


                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //error hole

                    }
                });
                String id= databaseReceiver.push().getKey();
                //temp.setDuid(uid);
               // r.setReceiverId(id);
                databaseReceiver.child(id).setValue(r);

                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                String tid=databaseDonation.push().getKey();

                Donation d=new Donation(uid,jakepathabotarnam,date);
                if(k==2) {
                    databaseDonation.child(tid).setValue(d);
                    b.dismiss();
                    Intent i = new Intent(ListActivity2.this,MyFragment1.class);
                    startActivity(i);
                }




            }
        });



    }

    protected void onStart() {
        super.onStart();
        databaseArtists.addValueEventListener(new ValueEventListener() {
            Intent j = getIntent();
            String area = j.getStringExtra("area");
            // Toast toast=Toast.makeText(getApplicationContext(),area,Toast.LENGTH_LONG);
            // toast.show();
            String number = j.getStringExtra("number");
            //  Toast toast1=Toast.makeText(getApplicationContext(),number,Toast.LENGTH_LONG);
            //toast1.show();
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {
                HungerList.clear();
                //change hole
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    //getting artist
                    rInfo temp = snapshot.getValue(rInfo.class);
                   // Integer.parseInt("4") == Integer.parseInt("04")
                    if(Integer.parseInt(temp.getRpeople()) <= Integer.parseInt(number) && temp.getRadd().equals(area))
                    {
                        HungerList.add(temp);

                    }


                    //adding artist to the list

                }




                //creating adapter
                HungerList Adapter = new HungerList(ListActivity2.this, HungerList);
                //attaching adapter to the listview
                listViewHungers.setAdapter(Adapter);


            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                //error hole

            }
        });
    }
}
