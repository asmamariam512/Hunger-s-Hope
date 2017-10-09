package com.example.windows.foodish;


        import android.app.Activity;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment3 extends Fragment {



    public MyFragment3() {
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
        return inflater.inflate(R.layout.fragment_my_fragment3, container, false);
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
