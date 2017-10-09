package com.example.windows.foodish;


        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ImageView;

public class FullImageActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image1);
        Intent i = getIntent();
        int position = i.getExtras().getInt("id");
        ImageAdapter1 adapter = new ImageAdapter1(this);
        ImageView imageView=(ImageView)findViewById(R.id.imageView1);
        imageView.setImageResource(adapter.images[position]);
    }
}
