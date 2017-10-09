package com.example.windows.foodish;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Windows on 08-Oct-17.
 */

public class HungerList2 extends ArrayAdapter<rInfo> {
    private Activity context;
    List<rInfo> HungerList2;

    public HungerList2(Activity context, List<rInfo> HungerList2) {
        super(context, R.layout.list_layout4, HungerList2);
        this.context = context;
        this.HungerList2 = HungerList2;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout4, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textView5);
        TextView textViewContact = (TextView) listViewItem.findViewById(R.id.textView9);
        rInfo rInfo = HungerList2.get(position);
        textViewName.setText(rInfo.getRname());
        textViewContact.setText(rInfo.getRphone());

        return listViewItem;
    }
}
