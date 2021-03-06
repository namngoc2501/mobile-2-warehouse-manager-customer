package com.example.warehousemanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.warehousemanager.R;
import com.example.warehousemanager.object.Cart;
import com.example.warehousemanager.object.Product;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CustomAdapterProduct extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<Product> data;

    public CustomAdapterProduct(@NonNull Context context, int resource, ArrayList<Product> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        //
        NumberFormat currentLocale = NumberFormat.getInstance();
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        //

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null);

            viewHolder = new ViewHolder();
            viewHolder.giaTien = convertView.findViewById(R.id.tvPrice);
            viewHolder.ten = convertView.findViewById(R.id.tvName);
            viewHolder.imgHinhAnh = convertView.findViewById(R.id.imgHinh);
            convertView.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Product pc = data.get(position);
        viewHolder.giaTien.setText(en.format(pc.getGiaTien()) + "VNĐ");
        viewHolder.ten.setText(pc.getTenSanPham());
        Picasso.get().load(pc.getHinhAnh()).into(viewHolder.imgHinhAnh);
        return convertView;
    }

    private static class ViewHolder {
        TextView giaTien;
        TextView ten;
        ImageView imgHinhAnh;
    }
}
