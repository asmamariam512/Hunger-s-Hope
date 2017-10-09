package com.example.windows.foodish;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Windows on 25-Sep-17.
 */

public class HungerList extends ArrayAdapter<rInfo> {
    private Activity context;
    List<rInfo> HungerList;

    public HungerList(Activity context, List<rInfo> HungerList) {
        super(context, R.layout.list_layout2, HungerList);
        this.context = context;
        this.HungerList = HungerList;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout2, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewCapacity = (TextView) listViewItem.findViewById(R.id.textViewCapacity);
        rInfo rInfo = HungerList.get(position);
        textViewName.setText(rInfo.getRname());
        textViewCapacity.setText(rInfo.getRpeople());

        return listViewItem;
    }
}
