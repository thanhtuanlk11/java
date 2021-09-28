package com.example.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListViewAdapter extends BaseAdapter {
    ArrayList<Product> list;
    public MyListViewAdapter(ArrayList<Product> list){
        this.list = list;
    }
    @Override
    public int getCount(){
        return list.size();
    }
    @Override
    public  Object getItem(int position){
        return list.get(position);
    }
    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View covertView, ViewGroup parent){
        View view = View.inflate(parent.getContext(),R.layout.row,null);
        Product product= (Product)getItem(position);
        ImageView img = view.findViewById(R.id.imgRow);
        img.setImageResource(product.image);
        TextView txtTitle = view.findViewById(R.id.txtTitle);
        txtTitle.setText(product.title);
        TextView txtContent = view.findViewById(R.id.txtContent);
        txtContent.setText(product.content);
        return view;
    }
}
