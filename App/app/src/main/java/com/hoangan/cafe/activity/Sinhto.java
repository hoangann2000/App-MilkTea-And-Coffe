package com.hoangan.cafe.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.hoangan.cafe.R;
import com.hoangan.cafe.adapter.SinhtoAdapter;
import com.hoangan.cafe.loop.Connect;
import com.hoangan.cafe.loop.Ok;
import com.hoangan.cafe.model.Sanpham;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Sinhto extends AppCompatActivity {
    Toolbar toolbarsinhto;
    RecyclerView recyclerviewsinhto;
    SinhtoAdapter sinhtoAdapter;
    ArrayList<Sanpham> mangsinhto = new ArrayList<>();
    int idst = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinhto);
        Anhxa();
        if(Connect.haveNetworkConnection(getApplicationContext())) {
            layIDst();
            Actionbar();
            DuLieuSinhTo();
        } else {
            Connect.ShowToast_short(getApplicationContext(),"kiểm tra internet");
            finish();
        }

    }

    private void DuLieuSinhTo() {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Ok.linksinhto, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null){
                    int id =0;
                    String tensinhto ="";
                    int giasinhto=0;
                    String hinhanhsinhto="";
                    String Motasinhto="";
                    int idsinhto =0;
                    for(int i = 0;i<response.length();i++){
                        try {
                            JSONObject jsonObject=response.getJSONObject(i);
                            id =jsonObject.getInt("id");
                            tensinhto=jsonObject.getString("tensanpham");
                            giasinhto=jsonObject.getInt("giasanpham");
                            hinhanhsinhto=jsonObject.getString("hinhanhsanpham");
                            Motasinhto=jsonObject.getString("motasanpham");
                            idsinhto=jsonObject.getInt("idsanpham");
                            mangsinhto.add(new Sanpham(id,tensinhto,giasinhto,hinhanhsinhto,Motasinhto,idsinhto));
                            sinhtoAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void Actionbar() {
        setSupportActionBar(toolbarsinhto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarsinhto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void layIDst() {
        idst = getIntent().getIntExtra("idloaisanpham",-1);

    }

    private void Anhxa() {
        toolbarsinhto = findViewById(R.id.toolbarsinhto);
        recyclerviewsinhto = findViewById(R.id.recyclerviewsinhto);
        sinhtoAdapter = new SinhtoAdapter(this,mangsinhto);
        recyclerviewsinhto.setHasFixedSize(true);
        recyclerviewsinhto.setLayoutManager(new LinearLayoutManager(this));
        recyclerviewsinhto.setAdapter(sinhtoAdapter);
    }
}