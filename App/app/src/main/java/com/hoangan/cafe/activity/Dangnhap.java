package com.hoangan.cafe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
import com.hoangan.cafe.loop.Ok;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Dangnhap extends AppCompatActivity {
    Button bttdangnhap,bttdangky;
    EditText   email,password;
    private TextView txtvcanhbao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        anhxa();
        bttdangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Dangky.class));
            }
        });

        bttdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = email.getText().toString().trim();
                String mPass = password.getText().toString().trim();
                if(!mEmail.isEmpty() || !mPass.isEmpty()) {
                    login(mEmail,mPass);
                }else {
                    email.setError("Điền email");
                    password.setError("Điền mật khẩu");
                }
            }


        });


    }

    private void login(String email, String password) {
        final RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Ok.dangnhap, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("login");

                    if (success.equals("1")) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String name = object.getString("name").trim();
                             String email = object.getString("email").trim();

                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            intent.putExtra("name",name);
                            intent.putExtra("email",email);
                            startActivity(intent);


                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(Dangnhap.this, "Lỗi" + e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Dangnhap.this, "Lỗi" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap = new HashMap<String, String>();
                hashMap.put("email",email);
                hashMap.put("password",password);
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void anhxa(){
        txtvcanhbao=(TextView)findViewById(R.id.textviewcanhbaodangnhap);
        bttdangky=(Button)findViewById(R.id.buttondangky);
        bttdangnhap=(Button)findViewById(R.id.buttondangnhap);
        password=(EditText)findViewById(R.id.password);
        email=(EditText)findViewById(R.id.email);
    }
}
