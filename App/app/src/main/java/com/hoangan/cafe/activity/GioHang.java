package com.hoangan.cafe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hoangan.cafe.R;
import com.hoangan.cafe.adapter.GioHangAdapter;
import com.hoangan.cafe.loop.Connect;

public class GioHang extends AppCompatActivity {
   Toolbar toolbargiohang;
    TextView tengiohang;
    TextView giagiohang;
    Button btnmuahang;
    Button btnmuatiep;
    GioHangAdapter gioHangAdapter;
    RecyclerView recyclerViewgiohang;
    public static TextView textViewtongtien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        AnhXa();
        Toolbarrr();
        DuLieuGioHang();
        ClickTieptucmua();
        ClickThanhToan();
    }

    private void ClickThanhToan() {
        btnmuahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.arrayListGioHang.size() > 0){
                    Intent intent = new Intent(getApplicationContext(),ThanhToan.class);
                    startActivity(intent);
                }else{
                    Connect.ShowToast_short(getApplicationContext(),"chưa có sản phẩm");
                }
            }
        });
    }

    private void ClickTieptucmua() {
        btnmuatiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }


    public static void DuLieuGioHang() {
       int tongCart = 0;
        for(int i=0;i<MainActivity.arrayListGioHang.size();i++){
            tongCart += MainActivity.arrayListGioHang.get(i).getGiasp() * MainActivity.arrayListGioHang.get(i).getSoluong();
            //DecimalFormat decimalFormat =   new DecimalFormat("###,###,###");
        }
        textViewtongtien.setText(String.valueOf(tongCart));
    }

    private void Toolbarrr() {
        setSupportActionBar(toolbargiohang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbargiohang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void AnhXa() {
        toolbargiohang = findViewById(R.id.toolbargiohang);
        tengiohang = findViewById(R.id.textviewtengiohang);
        giagiohang = findViewById(R.id.textviewgiagiohang);
        btnmuahang = findViewById(R.id.btnmuahang);
        btnmuatiep = findViewById(R.id.btntieptuc);
        recyclerViewgiohang = findViewById(R.id.recyclerviewgiohang);
        gioHangAdapter = new GioHangAdapter(GioHang.this,MainActivity.arrayListGioHang);
        recyclerViewgiohang.setAdapter(gioHangAdapter);
        textViewtongtien = findViewById(R.id.textviewtongtien);

        recyclerViewgiohang.setLayoutManager(new LinearLayoutManager(this));
    }
}