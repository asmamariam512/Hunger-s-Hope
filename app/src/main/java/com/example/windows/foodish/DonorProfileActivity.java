package com.example.windows.foodish;


        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import com.google.firebase.auth.FirebaseAuth;


public class DonorProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private Button logoutBtn;
    private Button share;
    private Button graph;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        logoutBtn = (Button) findViewById(R.id.buttonLogout);
        graph = (Button) findViewById(R.id.buttonGraph);
        share=(Button) findViewById(R.id.buttonShare);

        logoutBtn.setOnClickListener(this);
        graph.setOnClickListener(this);
        share.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == logoutBtn){
            firebaseAuth.signOut();
            startActivity(new Intent(DonorProfileActivity.this, SignInActivity.class));
        }
        if (view == graph){

            startActivity(new Intent(DonorProfileActivity.this, DonationActivity.class));
        }
        if (view == share){

            startActivity(new Intent(DonorProfileActivity.this, FindHunger.class));
        }
    }
    public void onBackPressed(){

        startActivity(new Intent(DonorProfileActivity.this, MainActivity.class)); ///can manupulate the back button

    }
}


