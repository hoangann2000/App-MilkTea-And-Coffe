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
import com.hoangan.cafe.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SinhtoAdapter extends RecyclerView.Adapter<SinhtoAdapter.ViewHolder> {
    Context context;
    List<Sanpham> arraylistsinhto = new ArrayList<>();

    public SinhtoAdapter(Context context, List<Sanpham> arraylistsinhto) {
        this.context = context;
        this.arraylistsinhto = arraylistsinhto;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_sinhto,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtsinhto.setText(arraylistsinhto.get(position).getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgiasinhto.setText("Gía : "+decimalFormat.format(arraylistsinhto.get(position).getGiasanpham())+" VNĐ");
        //holder.txtgia.setText(arraylistcafe.get(position).getGiasanpham());
        Picasso.get().load(arraylistsinhto.get(position).getHinhanhsanpham()).into(holder.imgsinhto);

        holder.imgsinhto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Chitietsanpham.class);
                intent.putExtra("chitietsanpham",arraylistsinhto.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arraylistsinhto.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgsinhto;
        TextView txtsinhto;
        TextView txtgiasinhto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgsinhto = itemView.findViewById(R.id.imageviewsinhto);
            txtsinhto = itemView.findViewById(R.id.textviewtensinhto);
            txtgiasinhto = itemView.findViewById(R.id.textviewgiasinhto);
        }
    }
}
