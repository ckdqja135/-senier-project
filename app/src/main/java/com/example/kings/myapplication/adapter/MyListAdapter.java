package com.example.kings.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kings.myapplication.R;
import com.example.kings.myapplication.vo.NoticeVO;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter{
    Context context;
    ArrayList<NoticeVO> list_itemArrayList;

    TextView title_textView;
    TextView date_textView;
    TextView content_textView;

    public MyListAdapter(Context context, ArrayList<NoticeVO> list_itemArrayList) {
        this.context = context;
        this.list_itemArrayList = list_itemArrayList;
    }
    @Override
    public int getCount() {
        return this.list_itemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list_itemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.notice,null);
            content_textView = (TextView)convertView.findViewById(R.id.content_textview);
            date_textView = (TextView)convertView.findViewById(R.id.date_textview);
            title_textView  =(TextView)convertView.findViewById(R.id.title_textview);

        }
        title_textView.setText(list_itemArrayList.get(position).getS_notiSubject());
        content_textView.setText(list_itemArrayList.get(position).getS_notiContent());

        return convertView;
    }
}


