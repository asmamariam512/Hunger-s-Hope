package com.example.windows.foodish;



        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.GridView;

public class Gallery1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery1);
        GridView gridView=(GridView)findViewById(R.id.gridView1);
        gridView.setAdapter(new ImageAdapter1(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent i=new Intent(getApplicationContext(),FullImageActivity1.class);
                i.putExtra("id",position);
                startActivity(i);

            }
        });
    }
}
