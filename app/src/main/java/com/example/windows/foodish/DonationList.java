package com.example.windows.foodish;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Windows on 07-Oct-17.
 */

public class DonationList extends ArrayAdapter<Donation> {
    private Activity context;
    List<Donation> DonationList;

    public DonationList(Activity context, List<Donation> DonationList) {
        super(context, R.layout.list_layout3, DonationList);
        this.context = context;
        this.DonationList = DonationList;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout3, null, true);

        TextView textViewName1 = (TextView) listViewItem.findViewById(R.id.textView20);
        TextView textViewCapacity1 = (TextView) listViewItem.findViewById(R.id.textView21);
        Donation d = DonationList.get(position);
        textViewName1.setText(d.getRname());
        textViewCapacity1.setText(d.getDate());

        return listViewItem;
    }
}
