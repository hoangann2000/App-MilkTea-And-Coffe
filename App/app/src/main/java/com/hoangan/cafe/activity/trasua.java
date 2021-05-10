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
import com.hoangan.cafe.adapter.TrasuaAdapter;
import com.hoangan.cafe.loop.Connect;
import com.hoangan.cafe.loop.Ok;
import com.hoangan.cafe.model.Sanpham;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class trasua extends AppCompatActivity {
    Toolbar toolbartrasua;
    RecyclerView recyclerviewtrasua;
    TrasuaAdapter trasuaAdapter;
    ArrayList<Sanpham> mangtrasua = new ArrayList<>();
    int idts = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasua);
        Anhxa();
        if(Connect.haveNetworkConnection(getApplicationContext())) {
            layIDts();
            Actionbar();
            DuLieuTraSua();
        } else {
            Connect.ShowToast_short(getApplicationContext(),"kiểm tra internet");
            finish();
        }

    }

    private void DuLieuTraSua() {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Ok.linktrasua, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null){
                    int id =0;
                    String tentrasua ="";
                    int giatrasua=0;
                    String hinhanhtrasua="";
                    String Motatrasua="";
                    int idtrasua =0;
                    for(int i = 0;i<response.length();i++){
                        try {
                            JSONObject jsonObject=response.getJSONObject(i);
                            id =jsonObject.getInt("id");
                            tentrasua=jsonObject.getString("tensanpham");
                            giatrasua=jsonObject.getInt("giasanpham");
                            hinhanhtrasua=jsonObject.getString("hinhanhsanpham");
                            Motatrasua=jsonObject.getString("motasanpham");
                            idtrasua=jsonObject.getInt("idsanpham");
                            mangtrasua.add(new Sanpham(id,tentrasua,giatrasua,hinhanhtrasua,Motatrasua,idtrasua));
                            trasuaAdapter.notifyDataSetChanged();
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
        setSupportActionBar(toolbartrasua);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbartrasua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void layIDts() {
        idts = getIntent().getIntExtra("idloaisanpham",-1);

    }

    private void Anhxa() {
        toolbartrasua = findViewById(R.id.toolbartrasua);
        recyclerviewtrasua = findViewById(R.id.recyclerviewtrasua);
       trasuaAdapter = new TrasuaAdapter(this , mangtrasua);
         trasuaAdapter.setData(mangtrasua);
        recyclerviewtrasua.setHasFixedSize(true);
        recyclerviewtrasua.setLayoutManager(new LinearLayoutManager(this));
        recyclerviewtrasua.setAdapter(trasuaAdapter);
    }
}