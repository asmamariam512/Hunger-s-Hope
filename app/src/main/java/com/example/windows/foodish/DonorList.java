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
 * Created by Windows on 20-Aug-17.
 */

public class DonorList extends ArrayAdapter<Donor> {
    private Activity context;
    List<Donor> DonorList;
    public DonorList(Activity context, List<Donor> DonorList) {
        super(context, R.layout.list_layout, DonorList);
        this.context = context;
        this.DonorList = DonorList;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewType = (TextView) listViewItem.findViewById(R.id.textViewType);

        Donor donor = DonorList.get(position);
        textViewName.setText(donor.getDname());
        textViewType.setText(donor.getDtype());

        return listViewItem;
    }
    public void onBackPressed(){

      //  startActivity(new Intent(Main2Activity.this, MainActivity.class)); ///can manupulate the back button

    }
}
