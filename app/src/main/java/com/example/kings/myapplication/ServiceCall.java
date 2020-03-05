package com.example.kings.myapplication;
import android.util.Log;

import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ServiceCall {
    private String url;
    private Request request;
    private OkHttpClient client;
    private JSONObject body;
    private RequestBody formBody;
    private ServiceCallBackListner o_serviceCallBack;

    public interface ServiceCallBackListner {
        void ServiceCallBack(JSONObject po_response);
    }

    public ServiceCall(String ps_url, ServiceCallBackListner o_callBack){
        this.url = ps_url;
        this.o_serviceCallBack = o_callBack;
        this.formBody = null;

        Service_Request();
    }

    public ServiceCall(String ps_url, FormBody p_formBody, ServiceCallBackListner o_callBack){
        this.url = ps_url;
        this.o_serviceCallBack = o_callBack;

        this.formBody = p_formBody;

        Service_Request();
    }

    public void Service_Request(){

        if(formBody == null){
            this.request = new Request.Builder()
                    .url(url)
                    .build();
            Log.d("LSJ" , "NULL");

        } else {
            this.request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
            Log.d("LSJ" , "NOTNULL");
        }

        Service_Client();
    }

    public void Service_Client(){
        this.client = new OkHttpClient();
        Log.d("LSJ" , "client");
        client.newCall(this.request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("KHJ", "콜백오류:"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("LSJ", "onResponse:" + response.body());
                try{
                    if ( o_serviceCallBack != null ) {
                        o_serviceCallBack.ServiceCallBack(new JSONObject(response.body().string()));
                    }
                } catch (JSONException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }

        });

    }

}
