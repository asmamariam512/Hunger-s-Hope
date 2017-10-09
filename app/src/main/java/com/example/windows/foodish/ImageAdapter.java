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

public class ImageAdapter extends BaseAdapter{
    private Context context;
    public Integer[] images = {
            R.drawable.pic1,

            R.drawable.pic3,

            R.drawable.pic5,


            R.drawable.pic6,

            R.drawable.pic7,

            R.drawable.pic8,


            R.drawable.pic9




    };
    public ImageAdapter (Context c){
        context=c;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new GridView.LayoutParams(500,500));
        return imageView;
    }
}
