package com.hoangan.cafe.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

import java.util.HashMap;
import java.util.Map;

public class ThanhToan extends AppCompatActivity {
        EditText edittenkhachhang,editsdt,editdiachi;
        Button btnthanhtoan,btnhuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        Anhxa();
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(Connect.haveNetworkConnection(getApplicationContext())){
            EventButton();
        }else {
            Connect.ShowToast_short(getApplicationContext(),"kiểm tra lại");
        }

    }

    private void EventButton() {

        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lấy dữ liệu từ editText
              final   String ten = edittenkhachhang.getText().toString().trim();
              final   String sdt =editsdt.getText().toString().trim();
                final  String diachi = editdiachi.getText().toString().trim();
                //kiem tra xem có rỗng không ?
                if(ten.length()>0 && sdt.length()>0 && diachi.length()>0) {
                    final RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Ok.insertdonhang, new Response.Listener<String>() {
                        @Override
                        public void onResponse(final String madonhang) {

                                        Connect.ShowToast_short(getApplicationContext(),"Cập nhật thông tin thành công");

//                            Log.d(madonhang, "madonhang");
//                            if(Integer.parseInt(madonhang)>0){
//                                RequestQueue queue=Volley.newRequestQueue(getApplicationContext());
//                                StringRequest  stringRequest1=new StringRequest(Request.Method.POST,Ok.donhang, new Response.Listener<String>() {
//                                    @Override
//                                    public void onResponse(String response) {
//                                        if(response.equals("1")){
//                                            MainActivity.arrayListGioHang.clear();
//                                            Connect.ShowToast_short(getApplicationContext(),"Bạn đã thêm giỏ hàng thành công");
//                                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                                            Connect.ShowToast_short(getApplicationContext(),"Mời bạn tiếp tục mua sản phẩm");
//                                        }else{
//                                            Connect.ShowToast_short(getApplicationContext(),"dữ liệu của bạn đã bị lỗi");
//                                        }
//                                    }
//                                }, new Response.ErrorListener() {
//                                    @Override
//                                    public void onErrorResponse(VolleyError error) {
//
//                                    }
//                                }){
//                                    @Override
//                                    protected Map<String, String> getParams() throws AuthFailureError {
//                                        JSONArray jsonArray=new JSONArray();
//
//                                        for(int i=0;i<MainActivity.arrayListGioHang.size();i++){
//                                            JSONObject object=new JSONObject();
//                                            try {
//                                                object.put("madonhang",madonhang);
//                                                object.put("masanpham",MainActivity.arrayListGioHang.get(i).getIdsp());
//                                                object.put("soluongsanpham",MainActivity.arrayListGioHang.get(i).getSoluong());
//                                                object.put("tientungsanpham",MainActivity.arrayListGioHang.get(i).getGiasp());
//                                            } catch (JSONException e) {
//                                                e.printStackTrace();
//                                            }
//                                            jsonArray.put(object);
//
//                                        }
//                                        HashMap<String,String> hashMap=new HashMap<String, String>();
//                                        hashMap.put("json",jsonArray.toString());
//                                        return hashMap;
//                                    }
//                                };
//                                queue.add(stringRequest1);
//                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String,String> hashMap = new HashMap<String,String>();
                            hashMap.put("tenkhachhang",ten);
                            hashMap.put("sodienthoai",sdt);
                            hashMap.put("diachi",diachi);
                            return hashMap;
                        }
                    };
                    requestQueue.add(stringRequest);
                }else {
                    Connect.ShowToast_short(getApplicationContext(),"rỗng");
                }
            }
        });
  }

    private void Anhxa() {
        edittenkhachhang = findViewById(R.id.edittenkhachhang);
        editsdt = findViewById(R.id.editsdt);
        editdiachi = findViewById(R.id.editdiachi);
        btnthanhtoan = findViewById(R.id.btnxacnhan);
        btnhuy = findViewById(R.id.btnhuy);
    }
}