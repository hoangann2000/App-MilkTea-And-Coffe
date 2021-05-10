package com.hoangan.cafe.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hoangan.cafe.R;
import com.hoangan.cafe.activity.GioHang;
import com.hoangan.cafe.activity.MainActivity;
import com.hoangan.cafe.model.Cart;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.ViewHolder> {
    Context context;
    List<Cart> arraylistGioHang;
    private int tong;

    public GioHangAdapter(Context context, List<Cart> arraylistGioHang) {
        this.context = context;
        this.arraylistGioHang = arraylistGioHang;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_giohang,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final  Cart cart = arraylistGioHang.get(position);
        Picasso.get().load(arraylistGioHang.get(position).getHinhanhsp()).into(holder.imggiohang);
        holder.txttengiohang.setText(arraylistGioHang.get(position).getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
         holder.txtgiagiohang.setText("Gía : "+decimalFormat.format(arraylistGioHang.get(position).getGiasp())+" VNĐ");
        holder.btnvalues.setText(arraylistGioHang.get(position).getSoluong() + "");
        int sl = Integer.parseInt(holder.btnvalues.getText().toString());
        holder.btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sl = MainActivity.arrayListGioHang.get(position).getSoluong();
                MainActivity.arrayListGioHang.get(position).setSoluong(sl + 1);
                holder.btnvalues.setText((sl + 1) + "");
                tong = cart.getGiasp() *(sl+1);
                String gia = tong + "VNĐ";
                holder.txtgiagiohang.setText(gia);
                GioHang.DuLieuGioHang();
               if((sl +1)==10) {
                   holder.btncong.setVisibility(View.INVISIBLE);
               }
            }
        });
        holder.btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sl = MainActivity.arrayListGioHang.get(position).getSoluong();
                MainActivity.arrayListGioHang.get(position).setSoluong(sl-1);
                holder.btnvalues.setText((sl-1)+"");
                tong = cart.getGiasp() *(sl-1);
                String gia = tong + "VNĐ";
                holder.txtgiagiohang.setText(gia);
                GioHang.DuLieuGioHang();
                if (sl <= 10 && holder.btncong.getVisibility() == View.INVISIBLE){
                    holder.btncong.setVisibility(View.VISIBLE);

                }
                if((sl - 1)==0){
                    MainActivity.arrayListGioHang.remove(position);
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arraylistGioHang.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imggiohang;
            TextView txttengiohang;
            TextView txtgiagiohang;
            Button btntru;
            Button btnvalues;
            Button btncong;
            TextView textviewtongtien;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imggiohang = itemView.findViewById(R.id.imageviewgiohang);
            txttengiohang = itemView.findViewById(R.id.textviewtengiohang);
            txtgiagiohang = itemView.findViewById(R.id.textviewgiagiohang);
            btntru = itemView.findViewById(R.id.btntru);
            btnvalues = itemView.findViewById(R.id.buttongiohangvalues);
            btncong = itemView.findViewById(R.id.btncong);
            textviewtongtien = itemView.findViewById(R.id.textviewtongtien);
        }
    }
}
