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
import com.hoangan.cafe.adapter.CafeAdapter;
import com.hoangan.cafe.loop.Connect;
import com.hoangan.cafe.loop.Ok;
import com.hoangan.cafe.model.Sanpham;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Coffe extends AppCompatActivity implements OnClickRecyclerview{
    Toolbar toolbarcafe;
    RecyclerView recyclerviewcafe;
    CafeAdapter cafeAdapter;
    ArrayList<Sanpham> mangcafe = new ArrayList<>();
    int idcf = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffe);
        Anhxa();
        if(Connect.haveNetworkConnection(getApplicationContext())) {
            LayID();
            DuLieuCafe();
            ActionToolbar();
            ClickChiTiet();
        }else {
            Connect.ShowToast_short(getApplicationContext(),"Kiểm tra internet");
            finish();
        }


    }

    private void ClickChiTiet() {

    }

    @Override
    public void Onclick(int position) {
//        Intent intent = new Intent(getApplicationContext(),Chitietsanpham.class);
//        intent.putExtra("chitietsanpham",mangcafe.get(position));
//        startActivity(intent);
    }

    public interface ItemClickListener {
        void onClick(View view, int position,boolean isLongClick);
    }

    private void DuLieuCafe() {
        RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Ok.linkcafe, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null){
                    int id =0;
                    String tencafe ="";
                    int giacafe=0;
                    String hinhanhcafe="";
                    String Motacafe="";
                    int idcafe =0;
                    for(int i = 0;i<response.length();i++){
                        try {
                            JSONObject jsonObject=response.getJSONObject(i);
                            id =jsonObject.getInt("id");
                            tencafe=jsonObject.getString("tensanpham");
                            giacafe=jsonObject.getInt("giasanpham");
                            hinhanhcafe=jsonObject.getString("hinhanhsanpham");
                            Motacafe=jsonObject.getString("motasanpham");
                            idcafe=jsonObject.getInt("idsanpham");
                            mangcafe.add(new Sanpham(id,tencafe,giacafe,hinhanhcafe,Motacafe,idcafe));
                            cafeAdapter.notifyDataSetChanged();
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


    private void ActionToolbar() {
        setSupportActionBar(toolbarcafe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarcafe.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            finish();
         }
     });

    }

    private void LayID() {
            idcf = getIntent().getIntExtra("idloaisanpham",-1);
    }

    private void Anhxa() {
        toolbarcafe = findViewById(R.id.toolbarcafe);
        recyclerviewcafe = findViewById(R.id.recyclerviewcafe);
        cafeAdapter = new CafeAdapter(this, Coffe.this, mangcafe );
//        cafeAdapter.setData(mangcafe);
        recyclerviewcafe.setHasFixedSize(true);
        recyclerviewcafe.setLayoutManager(new LinearLayoutManager(this));
        recyclerviewcafe.setAdapter(cafeAdapter);
    }

}