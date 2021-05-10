package com.hoangan.cafe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.hoangan.cafe.R;
import com.hoangan.cafe.model.Cart;
import com.hoangan.cafe.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class Chitietsanpham extends AppCompatActivity {
    Toolbar toolbarctsp;
    ImageView imageviewctsp;
    TextView textviewtenctsp;
    TextView textviewgiactsp;
    ImageButton buttongiohang;
    Spinner spinner;
    TextView textviewmotactsp;
     int id=0;
     String TenChiTiec="";
     int GiaChitiec=0;
     String hinhanhchitiec="";
     String MoTachitiec="";
     int idsanpham=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietsanpham);
        Sanpham sanpham = (Sanpham) getIntent().getSerializableExtra("chitietsanpham");
        Anhxa();
        Actiontoolbar();
        GetData(sanpham);
        ClickCart(sanpham);
        ClickSpinner();
    }

    private void ClickSpinner() {
        Integer[] soluong = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapter =  new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_dropdown_item,soluong);
        spinner.setAdapter(arrayAdapter);
    }

    private void ClickCart(Sanpham sanpham) {
        buttongiohang.setOnClickListener(new View.OnClickListener() {
            int soluong = 0;
            int tonggia = 0;
            @Override
            public void onClick(View v) {
                if(MainActivity.arrayListGioHang.size() >0) {
                    // lấy số lượng từ snipper
                    int update_sl = Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean itemExist = false;
                    for (int i = 0; i <MainActivity.arrayListGioHang.size(); i++) {
                        if (MainActivity.arrayListGioHang.get(i).getIdsp() == sanpham.getId()) {
                            // lấy ra số lượng hiện tại của item đó trong mảng
                          MainActivity.arrayListGioHang.get(i).setSoluong(MainActivity.arrayListGioHang.get(i).getSoluong()+update_sl);
                            if(MainActivity.arrayListGioHang.get(i).getSoluong() >=10){
                                MainActivity.arrayListGioHang.get(i).setSoluong(10);
                            }

                            itemExist = true;
                        }
                    } // thế phải ngồi nhân xem có đúng k :D à chỗ đó á hả, đúng r
                    if (itemExist == false) {
                        int  soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                        tonggia = soluong * sanpham.getGiasanpham();
                        MainActivity.arrayListGioHang.add(new Cart(sanpham.getId(), sanpham.getTensanpham(), tonggia, sanpham.getHinhanhsanpham(),soluong));
                    }
                } else {
                    int  soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                    tonggia = soluong * sanpham.getGiasanpham();
                    MainActivity.arrayListGioHang.add(new Cart(sanpham.getId(), sanpham.getTensanpham(), tonggia, sanpham.getHinhanhsanpham(),soluong));
                }

                Intent intent = new Intent(getApplicationContext(),GioHang.class);
                startActivity(intent);
            }
        });
    }

    private void GetData(Sanpham sanpham) {
        textviewtenctsp.setText(sanpham.getTensanpham());
        textviewmotactsp.setText(sanpham.getMotasanpham());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        textviewgiactsp.setText("Gía "+decimalFormat.format(sanpham.getGiasanpham())+" đ");
        String url = sanpham.getHinhanhsanpham();
        Picasso.get().load(url).into(imageviewctsp);

}

    private void Actiontoolbar() {
        setSupportActionBar(toolbarctsp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarctsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        toolbarctsp = findViewById(R.id.toolbarctsp);
        imageviewctsp = findViewById(R.id.imageviewctsp);
        textviewtenctsp = findViewById(R.id.textviewtenctsp);
        textviewgiactsp = findViewById(R.id.textviewgiactsp);
        buttongiohang = findViewById(R.id.buttongiohang);
        spinner = findViewById(R.id.spinner);
        textviewmotactsp = findViewById(R.id.textviewmotactsp);
    }
}