package com.hoangan.cafe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hoangan.cafe.R;
import com.hoangan.cafe.model.Loaisp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoaispAdapter  extends BaseAdapter {
    public LoaispAdapter(ArrayList<Loaisp> arrayListloaisp, Context context) {
        this.arrayListloaisp = arrayListloaisp;
        this.context = context;
    }

    ArrayList<Loaisp> arrayListloaisp;
    Context context;
    @Override
    public int getCount() {
        // nhung gia tri trong mang
        return arrayListloaisp.size();
    }

    @Override
    public Object getItem(int position) {
        // tung thuoc tinh trong gia tri mang
        return arrayListloaisp.get(position);
    }

    @Override
    public long getItemId(int position) {
        return  position;
    }
    public static class ViewHolder {
        TextView txttenloaisp;
        ImageView imgloaisp;

    }
    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder Viewholder;
        if(view == null) {
            Viewholder= new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.listview_loaisp,null);
            Viewholder.imgloaisp=(ImageView)view.findViewById(R.id.imageviewloaisp);
            Viewholder.txttenloaisp=(TextView)view.findViewById(R.id.textviewloaisp);
            view.setTag(Viewholder);
        }else{
            Viewholder= (ViewHolder) view.getTag();
        }
        Loaisp loaisp=(Loaisp)getItem(i);
        Viewholder.txttenloaisp.setText(loaisp.getTenLoaisp());

        Picasso.get().load(loaisp.getHinhanhloaisp()).into(Viewholder.imgloaisp);
        return view;
    }

}
