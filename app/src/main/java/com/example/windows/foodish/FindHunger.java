package com.example.windows.foodish;



        import android.content.Intent;
        import android.os.Parcelable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class FindHunger extends AppCompatActivity implements View.OnClickListener {
    private Button find;
    private EditText editTextarea;
    private EditText editTextnumber;
    String area,number;
    final Intent in = new Intent(this , ListActivity2.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_hunger);
        find = (Button) findViewById(R.id.buttonfind);
        editTextarea = (EditText) findViewById(R.id.editTextarea);
        editTextnumber = (EditText) findViewById(R.id.editTextnumber);

        find.setOnClickListener(this);

        area=editTextarea.getText().toString().toLowerCase();
        number=editTextnumber.getText().toString();
     // in.putExtra("area", (Parcelable) editTextarea);
        in.putExtra("area",area);
        in.putExtra("number",number);
        //in.putExtra("number", (Parcelable)   editTextnumber );

    }

    @Override
    public void onClick(View view) {
        if (view == find){

           // startActivity(new Intent(FindHunger.this, FindPageActivity.class));
             //startActivity(new Intent(FindHunger.this, ListActivity2.class));
            startActivity(in);
        }
    }
}

