package com.example.kings.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.kings.myapplication.adapter.PcListAdapter;
import com.example.kings.myapplication.vo.PcVO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PcListActivity extends AppCompatActivity implements ServiceCall.ServiceCallBackListner{

    ListView lv_pcList;

    PcListAdapter adapter;

    ArrayList<PcVO> arrO_pcList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc_list);

        lv_pcList = (ListView) findViewById(R.id.lv_pcList);

        new ServiceCall("http://180.66.231.85:8081/pcList.php", this);
    }

    @Override
    public void ServiceCallBack(JSONObject po_response) {
        Log.e("PPAP", "서버에서 응답한 Body:" + po_response);
        JSONArray jArray;

        try {
            jArray = po_response.getJSONArray("list");

            arrO_pcList = new ArrayList<>();

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject obj = jArray.getJSONObject(i);
                arrO_pcList.add(
                        new PcVO(
                                obj.getInt("pc_no"),
                                obj.getString("pc_name"),
                                obj.getString("pc_tel"),
                                obj.getString("pc_address"),
                                obj.getString("pc_info"),
                                obj.getInt("pc_profile"),
                                obj.getInt("total_seat"),
                                obj.getInt("use_seat")
                        )
                );
            }
            PcListActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter = new PcListAdapter(arrO_pcList, PcListActivity.this);
                    lv_pcList.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            });

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
