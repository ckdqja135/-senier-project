package com.example.kings.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kings.myapplication.R;
import com.example.kings.myapplication.vo.LocationVO;

import java.util.ArrayList;

public class LocationListAdapter extends BaseAdapter {

    ArrayList<LocationVO> arrO_locatinList = new ArrayList<>();
    Context               o_context;

    public LocationListAdapter(ArrayList<LocationVO> parrO_locatinList, Context po_context) {
        this.arrO_locatinList = parrO_locatinList;
        this.o_context = po_context;
    }

    @Override
    public int getCount() {
        return arrO_locatinList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int pi_position, View po_convertView, ViewGroup po_parent) {
        LocationListViewHolder lo_viewHolder;

        if (po_convertView == null) {
            LayoutInflater o_inflater = ((Activity) o_context).getLayoutInflater();
            po_convertView = o_inflater.inflate(R.layout.location_list, null);
            lo_viewHolder = new LocationListViewHolder();

            lo_viewHolder.tv_locationName = (TextView) po_convertView.findViewById(R.id.tv_locationName);
            po_convertView.setTag(lo_viewHolder);
        } else {
            lo_viewHolder = (LocationListViewHolder) po_convertView.getTag();
        }

        lo_viewHolder.tv_locationName.setText(arrO_locatinList.get(pi_position).getS_locationName());

        return po_convertView;
    }

    class LocationListViewHolder {
        private TextView tv_locationName;
    }
}
