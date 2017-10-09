package com.example.windows.foodish;


        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;
        import java.util.List;

        import static com.example.windows.foodish.R.id.donationlist;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment1 extends Fragment {
    DatabaseReference databaseDonation;


    List<Donation> DonationList;



    public MyFragment1() {
        // Required empty public constructor
    }
    public void onAttach(Activity activity){
        super.onAttach(activity);
    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);






    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=getActivity().getLayoutInflater().inflate(R.layout.fragment_my_fragment1, container, false);
      Button  b = (Button)view.findViewById(R.id.button7);
       // TextView t=(TextView)view.findViewById(R.id.textfrag);
        //String name=this.getArguments().getString("usernamefrag").toString();
        //t.setText(name);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent in=new Intent(getActivity(),DonationActivity.class);  ///ekhane FindPageActivity dibo;;;

                 //Toast.makeText(getApplicationContext(),area, Toast.LENGTH_SHORT).show();


                startActivity(in);
            }
        });








        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onDestroy()
    {
        super.onDestroy();
    }
    public void onDetach(){
        super.onDetach();
    }

}
