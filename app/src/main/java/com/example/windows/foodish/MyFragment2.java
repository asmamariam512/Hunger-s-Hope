package com.example.windows.foodish;


        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;

        import static android.widget.Toast.LENGTH_SHORT;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment2 extends Fragment {

    private Button find;
    private EditText editTextarea1;
    private EditText editTextnumber1;

   //
    public MyFragment2() {
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

        // Inflate the layout for this fragment
        //View view= inflater.inflate(R.layout.fragment_my_fragment2, container, false);
        View view= getActivity().getLayoutInflater().inflate(R.layout.fragment_my_fragment2, container, false);
        find = (Button)view.findViewById(R.id.buttonfind);
        editTextarea1 = (EditText) view.findViewById(R.id.editTextarea);
        editTextnumber1 = (EditText) view.findViewById(R.id.editTextnumber);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = auth.getCurrentUser();
       String id = firebaseUser.getUid();
      //  Toast.makeText(this, "First Enter Your Past Info then New One", Toast.LENGTH_LONG).show();
        //Toast.makeText(getActivity(),id,Toast.LENGTH_SHORT).show();



        // in.putExtra("area", (Parcelable) editTextarea);



      //
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent in=new Intent(getActivity(),FindPageActivity.class);  ///ekhane FindPageActivity dibo;;;
                final String area = editTextarea1.getText().toString().toLowerCase().trim();
                final String number =editTextnumber1.getText().toString().trim();
                final Intent in = new Intent(getActivity(), ListActivity2.class);
                in.putExtra("area",area);
                in.putExtra("number",number);
               // Toast.makeText(getApplicationContext(),area,Toast.LENGTH_SHORT).show();


                startActivity(in);
            }
        });

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
