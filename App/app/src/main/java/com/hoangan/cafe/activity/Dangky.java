package com.hoangan.cafe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hoangan.cafe.R;
import com.hoangan.cafe.loop.Connect;
import com.hoangan.cafe.loop.Ok;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Dangky extends AppCompatActivity {
  EditText name;
   EditText pass;
   EditText email;
    EditText confirmpass;
  Button btn_regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);

        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        confirmpass = findViewById(R.id.confirmpass);
         email = findViewById(R.id.email);
        btn_regist = findViewById(R.id.btn_register);

        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regist();
            }
        });
    }

    private void Regist() {

        final String name = this.name.getText().toString().trim();
       final String email = this.email.getText().toString().trim();
       final  String pass = this.pass.getText().toString().trim();

        if (name.length() > 0 && email.length() > 0 && pass.length() > 0 && confirmpass.length() > 0) {
            final RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Ok.dangky, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String success = jsonObject.getString("success");
                        if(success.equals("1")) {
                            Toast.makeText(Dangky.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),Dangnhap.class);
                            startActivity(intent);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(Dangky.this, "Lỗi" +e.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String,String> hashMap = new HashMap<String, String>();
                    hashMap.put("name", name);
                   hashMap.put("email",email);
                   hashMap.put("password",pass);
                    return hashMap;
                }
            };
            requestQueue.add(stringRequest);
        }else{
            Connect.ShowToast_short(getApplicationContext(),"Hãy nhập đủ thông tin");
        }
    }
}