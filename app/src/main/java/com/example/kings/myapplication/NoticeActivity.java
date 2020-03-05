package com.example.kings.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.kings.myapplication.adapter.MyListAdapter;
import com.example.kings.myapplication.vo.NoticeVO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity implements ServiceCall.ServiceCallBackListner {
    ListView lv_notiList;

    Context o_context;

    ArrayList<NoticeVO> all = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice_main);

        o_context = this;

        lv_notiList = (ListView) findViewById(R.id.notice_View);

        new ServiceCall("http://180.66.231.85:8081/notice.php", this);
    }

    public void ServiceCallBack(JSONObject po_response) {
        Log.d("PPAP", "서버에서 응답한 Body:" + po_response);
        JSONArray jArray;
        try {
            jArray = po_response.getJSONArray("list");
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject obj = jArray.getJSONObject(i);
                String ps_notiSubject = obj.getString("noti_subject");
                String ps_notiContent = obj.getString("noti_content");
                all.add(new NoticeVO(ps_notiSubject, ps_notiContent));
            }

            MyListAdapter adapter = new MyListAdapter(o_context, all);
            lv_notiList.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}


