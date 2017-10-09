package com.example.windows.foodish;

/**
 * Created by Windows on 21-Aug-17.
 */


        import android.content.Context;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.GridView;
        import android.widget.ImageView;

/**
 * Created by Ananya on 8/15/2017.
 */

public class ImageAdapter1 extends BaseAdapter {
    private Context context;
    public Integer[] images = {
            R.drawable.food1,
            R.drawable.food2,
            R.drawable.food3,
            R.drawable.food4,
            R.drawable.food5

    };
    public ImageAdapter1 (Context c){
        context=c;
    }


    public int getCount() {
        return images.length;
    }


    public Object getItem(int position) {
        return images[position];
    }


    public long getItemId(int position) {
        return 0;
    }


    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new GridView.LayoutParams(240,240));
        return imageView;
    }
}
