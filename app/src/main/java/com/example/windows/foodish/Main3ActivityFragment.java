package com.example.windows.foodish;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Main3ActivityFragment extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private FirebaseAuth firebaseAuth;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ActionBar actionBar;
    private DrawerLayout drawerLayout;
    private ListView navlist;
    private android.support.v4.app.FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
public String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_fragment);
        Intent i=getIntent();
        s=i.getStringExtra("username");

        firebaseAuth = FirebaseAuth.getInstance();
         drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navlist=(ListView) findViewById(R.id.nav_list);
        ArrayList<String> navArray=new ArrayList<String>();
       // navArray.add("Home");
        navArray.add("My Donationns"); //////////////////////change krsi
        navArray.add("Share Food");
        navArray.add("LogOut");

        navlist.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,navArray);
        navlist.setAdapter(adapter);
       navlist.setOnItemClickListener(this);  //////////////////////////////////////
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.openDrawer,R.string.closeDrawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
         actionBar=getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        fragmentManager = getSupportFragmentManager();
        loadSelection(0);
    }
    private void loadSelection(int i) {         ///huddaiiii
        navlist.setItemChecked(i, true);
        switch (i){



        case 0:
           // Bundle bundle=new Bundle();
          //  bundle.putString("usernamefrag",s);

        MyFragment1 myFragment1=new MyFragment1();
          //  myFragment1.setArguments(bundle);
        fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_holder,myFragment1);
        fragmentTransaction.commit();
        break;
        case 1:
        MyFragment2 myFragment2=new MyFragment2();
        fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_holder,myFragment2);
        fragmentTransaction.commit();
        break;
        case 2:
        // MyFragment3 myFragment3=new MyFragment3();
        // fragmentTransaction=fragmentManager.beginTransaction();

        // fragmentTransaction.replace(R.id.fragment_holder,myFragment3);
        //
        // fragmentTransaction.commit();



      firebaseAuth.signOut();

       startActivity(new Intent(Main3ActivityFragment.this, MainActivity.class));

    }

}
    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        actionBarDrawerToggle.syncState();
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
    public boolean onOptionsItemSelected(MenuItem item){

        int id=item.getItemId();
        if(id==R.id.action_settings){
            return true;

        }else if(id==android.R.id.home){
            if(drawerLayout.isDrawerOpen(navlist)){
                drawerLayout.closeDrawer(navlist);

            }else
            {
                drawerLayout.openDrawer(navlist);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        loadSelection(position);



        drawerLayout.closeDrawer(navlist);

    }


}
