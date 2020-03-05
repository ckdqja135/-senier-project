package com.example.kings.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.FormBody;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener, ServiceCall.ServiceCallBackListner {

    EditText et_email,
             et_password,
             et_passwordConfirm;

    Button bt_done,
           bt_cancel;

    FormBody formBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membership);

        et_email           = (EditText) findViewById(R.id.etEmail);
        et_password        = (EditText) findViewById(R.id.etPassword);
        et_passwordConfirm = (EditText) findViewById(R.id.etPasswordConfirm);

        bt_done   = (Button) findViewById(R.id.btnDone);
        bt_cancel = (Button) findViewById(R.id.btnCancel);

        bt_done.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        int id = v.getId();

        switch (id){
            case R.id.btnDone :
                if(et_email.getText().toString().equals("")){
                    Toast.makeText(this, "아이디를 입력해주세요!", Toast.LENGTH_SHORT).show();
                    et_email.requestFocus();

                } else if(et_password.getText().toString().equals("")) {
                    Toast.makeText(this, "비밀번호를 입력해주세요!", Toast.LENGTH_SHORT).show();
                    et_password.requestFocus();

                } else if(et_passwordConfirm.getText().toString().equals("")) {
                    Toast.makeText(this, "비밀번호 확인을 입력해주세요!", Toast.LENGTH_SHORT).show();
                    et_passwordConfirm.requestFocus();

                } else if(!et_password.getText().toString().equals(et_passwordConfirm.getText().toString())){
                    Toast.makeText(this, "비밀번호와 비밀번호 확인이 다릅니다!", Toast.LENGTH_SHORT).show();
                    et_password.setText("");
                    et_passwordConfirm.setText("");
                    et_password.requestFocus();
                }

                formBody = new FormBody.Builder()
                        .add("id", et_email   .getText().toString())
                        .add("pw", et_password.getText().toString())
                        .build();

                new ServiceCall("http://180.66.231.85:8081/join.php", formBody, this);
                break;
            case R.id.btnCancel :
                startActivity(new Intent(JoinActivity.this, LoginActivity.class));
                finish();
                break;
        }
    }
    public void ServiceCallBack(final JSONObject po_response) {
        Log.e("PPAP", "서버에서 응답한 Body:" + po_response);

        try {
            final String success = po_response.getString("success");
            final String message = po_response.getString("message");
            (JoinActivity.this).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(success.equals("true")){
                        Toast.makeText(JoinActivity.this, "가입 성공!", Toast.LENGTH_SHORT).show();
                    } else {

                        if(message.equals("아이디 중복")){
                            Toast.makeText(JoinActivity.this, "가입 실패!\n아이디 중복.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(JoinActivity.this, "가입 실패!\n관리자에게 문의해주세요.", Toast.LENGTH_SHORT).show();
                        }

                    }
                    startActivity(new Intent(JoinActivity.this, LoginActivity.class));
                    finish();
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
