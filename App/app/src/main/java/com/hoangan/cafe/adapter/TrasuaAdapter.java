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

public class TrasuaAdapter extends RecyclerView.Adapter<TrasuaAdapter.ViewHolder> {
    Context context;
    List<Sanpham> arraylisttrasua = new ArrayList<>();

    public TrasuaAdapter(Context context, List<Sanpham> arraylisttrasua) {
        this.context = context;
        this.arraylisttrasua = arraylisttrasua;
    }

    public void setData(List<Sanpham> arraylisttrasua) {
        this.arraylisttrasua = arraylisttrasua;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_trasua,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txttrasua.setText(arraylisttrasua.get(position).getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgiatrasua.setText("Gía : "+decimalFormat.format(arraylisttrasua.get(position).getGiasanpham())+" VNĐ");
        //holder.txtgia.setText(arraylistcafe.get(position).getGiasanpham());
        Picasso.get().load(arraylisttrasua.get(position).getHinhanhsanpham()).into(holder.imgtrasua);

        holder.imgtrasua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(context, Chitietsanpham.class);
                intent.putExtra("chitietsanpham",arraylisttrasua.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arraylisttrasua.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgtrasua;
        TextView txttrasua;
        TextView txtgiatrasua;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgtrasua = itemView.findViewById(R.id.imageviewtrasua);
            txttrasua = itemView.findViewById(R.id.textviewtentrasua);
            txtgiatrasua = itemView.findViewById(R.id.textviewgiatrasua);
        }
    }
}
