package com.example.kings.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kings.myapplication.vo.UserVO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.FormBody;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, ServiceCall.ServiceCallBackListner {

    EditText et_email,
             et_password;

    Button bt_regist,
           bt_login;

    FormBody formBody;

    UserVO userVO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        et_email    = (EditText) findViewById(R.id.etEmail);
        et_password = (EditText) findViewById(R.id.etPassword);

        bt_login  = (Button) findViewById(R.id.btnLogin);
        bt_regist = (Button) findViewById(R.id.btnRegist);

        bt_regist.setOnClickListener(this);
        bt_login .setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        int id  = v.getId();

        switch (id){
            case R.id.btnLogin :
                formBody = new FormBody.Builder()
                        .add("id", et_email   .getText().toString())
                        .add("pw", et_password.getText().toString())
                        .build();

                new ServiceCall("http://180.66.231.85:8081/login.php", formBody ,this);

                break;
            case R.id.btnRegist :
                startActivity(new Intent(LoginActivity.this, JoinActivity.class));
                break;
        }
    }

    public void ServiceCallBack(JSONObject po_response) {
        Log.e("PPAP", "서버에서 응답한 Body:" + po_response);
        JSONArray jArray;

        try {

            if (po_response.getString("success").equals("false")) {
                (LoginActivity.this).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LoginActivity.this, "로그인 실패!\n아이디나 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    }
                });
                return;
            }

            jArray = po_response.getJSONArray("list");

            JSONObject obj = jArray.getJSONObject(0);
            String ps_userNo = obj.getString("user_no");
            String ps_userId = obj.getString("user_id");
            String ps_userName = obj.getString("user_name");

            userVO = new UserVO(ps_userNo, ps_userId, ps_userName);

            (LoginActivity.this).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(LoginActivity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class).putExtra("userVO", userVO));
                    finish();
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
