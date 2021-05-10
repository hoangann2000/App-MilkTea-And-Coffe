package com.hoangan.cafe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hoangan.cafe.R;
import com.hoangan.cafe.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.ItemHolder> {
    Context context;
    ArrayList<Sanpham> arraysanpham;

    public SanphamAdapter(Context context, ArrayList<Sanpham> arraysanpham) {
        this.context = context;
        this.arraysanpham = arraysanpham;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sanpham,null);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
         Sanpham sanpham = arraysanpham.get(position);
         holder.txttensanpham.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
//        holder.txtgiasanpham.setText("Giá: "+ decimalFormat.format(sanpham.getGiasanpham()+ "VNĐ"));
       holder.txtgiasanpham.setText("Gía : "+decimalFormat.format(sanpham.getGiasanpham())+" VNĐ");
        Picasso.get().load(sanpham.getHinhanhsanpham()).into(holder.imghinhanhsanpham);

    }
    @Override
    public int getItemCount() {
        return arraysanpham.size();
    }

    public  class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imghinhanhsanpham;
        public TextView txttensanpham;
        public  TextView txtgiasanpham;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imghinhanhsanpham = itemView.findViewById(R.id.imageviewsanpham);
            txttensanpham = itemView.findViewById(R.id.textviewtensanpham);
            txtgiasanpham = itemView.findViewById(R.id.textviewgiasanpham);

        }
    }

}
