package com.hoangan.cafe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;
import com.hoangan.cafe.R;
import com.hoangan.cafe.adapter.LoaispAdapter;
import com.hoangan.cafe.adapter.SanphamAdapter;
import com.hoangan.cafe.loop.Connect;
import com.hoangan.cafe.loop.Ok;
import com.hoangan.cafe.model.Cart;
import com.hoangan.cafe.model.Loaisp;
import com.hoangan.cafe.model.Sanpham;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbartrangchu;
    RecyclerView recyclerview;
    NavigationView navigationview;
    ListView listviewtrangchu;
    DrawerLayout drawerlayout;
    ArrayList<Loaisp> mangloaisp;
    LoaispAdapter loaispAdapter;
    int id = 0;
    String tenLoaisp ="";
    String hinhanhloaisp = "";
    ArrayList<Sanpham> mangsanpham;
    SanphamAdapter sanphamAdapter;

    public static ArrayList<Cart> arrayListGioHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Anhxa();
        if(Connect.haveNetworkConnection(getApplicationContext())){
            ActionBar();
            DuLieuMenu();
            DuLieuSanPham();
            ClickMenu();

        }else{
            Connect.ShowToast_short(getApplicationContext(),"Kiem tra internet");
            finish();
        }

    }

    private void ClickMenu() {
        listviewtrangchu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);
                        drawerlayout.closeDrawer(GravityCompat.END);
                        break;
                    case 1:
                        Intent intent1 = new Intent(MainActivity.this,Coffe.class);
                        intent1.putExtra("idloaisanpham",mangloaisp.get(position).getId());
                        startActivity(intent1);
                        drawerlayout.closeDrawer(GravityCompat.END);
                        break;
                    case 2:
                        Intent intent2 = new Intent(MainActivity.this,Sinhto.class);
                        intent2.putExtra("idloaisanpham",mangloaisp.get(position).getId());
                        startActivity(intent2);
                        drawerlayout.closeDrawer(GravityCompat.END);
                        break;
                    case 3:
                        Intent intent3 = new Intent(MainActivity.this,trasua.class);
                        intent3.putExtra("idloaisanpham",mangloaisp.get(position).getId());
                        startActivity(intent3);
                        drawerlayout.closeDrawer(GravityCompat.END);
                        break;
                    case 4:
                        Intent intent4 = new Intent(MainActivity.this,thongtin.class);
                        startActivity(intent4);
                        drawerlayout.closeDrawer(GravityCompat.END);
                        break;
                    case 5:
                       finish();
                        break;
                }
            }
        });
    }


    private void DuLieuSanPham() {
        RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Ok.linksp, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null){
                    int ID=0;
                    String Tensanpham="";
                    Integer Giasanpham=0;
                    String Hinhanhsanpham="";
                    String Motasanpham="";
                    int IDsanpham=0;
                    for(int i = 0;i<response.length();i++){
                        try {
                            JSONObject jsonObject=response.getJSONObject(i);
                            ID=jsonObject.getInt("id");
                            Tensanpham=jsonObject.getString("temsanpham");
                            Giasanpham=jsonObject.getInt("giasanpham");
                            Hinhanhsanpham=jsonObject.getString("hinhanhsanpham");
                            Motasanpham=jsonObject.getString("motasanpham");
                            IDsanpham=jsonObject.getInt("idsanpham");
                            mangsanpham.add(new Sanpham(ID,Tensanpham,Giasanpham,Hinhanhsanpham,Motasanpham,IDsanpham));
                            sanphamAdapter.notifyDataSetChanged();
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




    private void DuLieuMenu() {
      RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Ok.linkLoaisp, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null) {
                    for(int i = 0 ; i<response.length();i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id =jsonObject.getInt("id");
                            tenLoaisp = jsonObject.getString("tenLoaisp");
                            hinhanhloaisp = jsonObject.getString("hinhanhloaisp");
                            mangloaisp.add(new Loaisp(id,tenLoaisp,hinhanhloaisp));
                            loaispAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                mangloaisp.add(0,new Loaisp(0,"Trang Chính","https://img.icons8.com/doodle/5x/home.png"));
                mangloaisp.add(4,new Loaisp(0,"Liên Hệ","https://img.icons8.com/bubbles/2x/contact-card.png"));
                mangloaisp.add(5,new Loaisp(0,"Đăng Xuất","https://img.icons8.com/fluent/150/logout-rounded.png"));

                loaispAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Connect.ShowToast_short(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void Anhxa() {

        toolbartrangchu = findViewById(R.id.toolbarcafe);
        recyclerview = findViewById(R.id.recyclerview);
        navigationview = (NavigationView) findViewById(R.id.navigationview);
        listviewtrangchu = findViewById(R.id.listviewtrangchu);
        drawerlayout = findViewById(R.id.drawerlayout);
        mangloaisp = new ArrayList<>();
        loaispAdapter = new LoaispAdapter(mangloaisp,getApplicationContext());
        listviewtrangchu.setAdapter(loaispAdapter);
        mangsanpham = new ArrayList<>();
        sanphamAdapter = new SanphamAdapter(getApplicationContext(),mangsanpham);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerview.setAdapter(sanphamAdapter);

        if(arrayListGioHang != null) {
        }else {
            arrayListGioHang = new ArrayList<>();
        }
    }

    private  void ActionBar() {
        setSupportActionBar(toolbartrangchu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbartrangchu.setNavigationIcon(android.R.drawable.sym_def_app_icon);
        toolbartrangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerlayout.openDrawer(GravityCompat.END);
            }
        });
    }

}
