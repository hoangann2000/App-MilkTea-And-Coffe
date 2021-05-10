package com.hoangan.cafe.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hoangan.cafe.R;
import com.hoangan.cafe.activity.Chitietsanpham;
import com.hoangan.cafe.activity.OnClickRecyclerview;
import com.hoangan.cafe.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CafeAdapter extends RecyclerView.Adapter<CafeAdapter.ViewHolder> {
    OnClickRecyclerview listener;
    Context context;
    List<Sanpham> arraylistcafe = new ArrayList<>();

    public CafeAdapter(OnClickRecyclerview listener, Context context, List<Sanpham> arraylistcafe) {
        this.listener = listener;
        this.context  = context;
        this.arraylistcafe = arraylistcafe;
    }

//    public void setData(List<Sanpham> arraylistcafe) {
//        this.arraylistcafe = arraylistcafe;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_coffe,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtcafe.setText(arraylistcafe.get(position).getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgia.setText("Gía : "+decimalFormat.format(arraylistcafe.get(position).getGiasanpham())+" VNĐ");
        //holder.txtgia.setText(arraylistcafe.get(position).getGiasanpham());
        Picasso.get().load(arraylistcafe.get(position).getHinhanhsanpham()).into(holder.imgcafe);
        holder.imgcafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Chitietsanpham.class);
                intent.putExtra("chitietsanpham",arraylistcafe.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arraylistcafe.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        int position;
        ImageView imgcafe;
        TextView txtcafe;
        TextView txtgia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.Onclick(position);
                }
            });
            imgcafe = itemView.findViewById(R.id.imageviewcafe);
            txtcafe = itemView.findViewById(R.id.textviewtencafe);
            txtgia = itemView.findViewById(R.id.textviewgiacafe);
        }
    }
}
