package com.example.kings.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kings.myapplication.R;
import com.example.kings.myapplication.vo.PcVO;

import java.util.ArrayList;

public class PcListAdapter extends BaseAdapter {

    ArrayList<PcVO> arrO_pcList = new ArrayList<>();
    Context         o_context;

    public PcListAdapter(ArrayList<PcVO> parrO_pcList, Context po_context) {
        this.arrO_pcList = parrO_pcList;
        this.o_context   = po_context;
    }

    @Override
    public int getCount() {
        return arrO_pcList.size();
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
        PcListViewHolder lo_viewHolder;

        try {
            if (po_convertView == null) {
                LayoutInflater o_inflater = ((Activity) o_context).getLayoutInflater();
                po_convertView = o_inflater.inflate(R.layout.pc_list_view, null);
                lo_viewHolder = new PcListViewHolder();

                lo_viewHolder.tv_pcName     = (TextView)  po_convertView.findViewById(R.id.pc_title);
                lo_viewHolder.tv_pcAddress  = (TextView)  po_convertView.findViewById(R.id.pc_address);
                lo_viewHolder.tv_totalSeat  = (TextView)  po_convertView.findViewById(R.id.pc_totalSeat);
                lo_viewHolder.tv_usingSeat  = (TextView)  po_convertView.findViewById(R.id.pc_usingSeat);
                lo_viewHolder.tv_remainSeat = (TextView)  po_convertView.findViewById(R.id.pc_spaceSeat);
                lo_viewHolder.iv_pcImg      = (ImageView) po_convertView.findViewById(R.id.pc_img);

                po_convertView.setTag(lo_viewHolder);
            } else {
                lo_viewHolder = (PcListViewHolder) po_convertView.getTag();
            }

            if (arrO_pcList.size() < 1 || pi_position < 0) {
                return po_convertView;
            }

            String ls_pcName     = arrO_pcList.get(pi_position).getS_pcName();
            String ls_pcAddress  = arrO_pcList.get(pi_position).getS_pcAddress();
            int    li_totalSeat  = arrO_pcList.get(pi_position).getI_totalSeat();
            int    li_usingSeat  = arrO_pcList.get(pi_position).getI_useSeat();
            int    li_remainSeat = li_totalSeat - li_usingSeat;

            lo_viewHolder.tv_pcName    .setText(ls_pcName);
            lo_viewHolder.tv_pcAddress .setText(ls_pcAddress);
            lo_viewHolder.tv_totalSeat .setText(String.valueOf(li_totalSeat));
            lo_viewHolder.tv_usingSeat .setText(String.valueOf(li_usingSeat));
            lo_viewHolder.tv_remainSeat.setText(String.valueOf(li_remainSeat));
        } catch (Exception e){
            e.printStackTrace();
            Log.e("PPAP", e.getMessage());
        }



//        Glide.with(o_context)
//             .load("http://180.66.231.85:8081/profile/"+ arrO_pcList.get(pi_position).getI_pcNo() + ".png")
//             .into(lo_viewHolder.iv_pcImg);

        return po_convertView;
    }

    class PcListViewHolder {
        private TextView  tv_pcName;
        private TextView  tv_pcAddress;
        private TextView  tv_totalSeat;
        private TextView  tv_usingSeat;
        private TextView  tv_remainSeat;
        private ImageView iv_pcImg;
    }
}
