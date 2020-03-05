package com.example.kings.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kings.myapplication.adapter.LocationListAdapter;
import com.example.kings.myapplication.vo.LocationVO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class LocationSelectActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, ServiceCall.ServiceCallBackListner {

    ListView            lv_locationList;
    LocationListAdapter adapter;

    ArrayList<LocationVO> arrO_locationList;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_select);

        intent = getIntent();
        lv_locationList = (ListView) findViewById(R.id.lv_locationList);

        new ServiceCall("http://180.66.231.85:8081/locationList.php", this);

        lv_locationList.setOnItemClickListener(this);
    }

    @Override
    public void ServiceCallBack(JSONObject po_response) {
        Log.e("PPAP", "서버에서 응답한 Body:" + po_response);
        JSONArray jArray;

        try {
            jArray = po_response.getJSONArray("list");
            arrO_locationList = new ArrayList<>();

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject obj = jArray.getJSONObject(i);

                arrO_locationList.add(
                        new LocationVO(
                                obj.getInt("location_no"),
                                obj.getString("location_name"),
                                obj.optInt("parent_no")
                        )
                );
            }

            LocationSelectActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter = new LocationListAdapter(arrO_locationList, LocationSelectActivity.this);
                    lv_locationList.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            });

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(intent.setClass(LocationSelectActivity.this, PcListActivity.class));
    }
}
