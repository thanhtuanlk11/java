package com.example.myapplication;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private String[] TenLogo;
    private  String [] Mota;
    private  int [] hinhLogo;

    public GridViewAdapter(Context context, String[] tenLogo, String[] mota, int[] hinhLogo) {
        this.context = context;
        TenLogo = tenLogo;
        this.Mota = mota;
        this.hinhLogo = hinhLogo;
    }


    @Override
    public int getCount() {
        return TenLogo.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.layout_gridview,null);
        TextView textView = (TextView) view.findViewById(R.id.txtView);
        TextView mota = (TextView) view.findViewById(R.id.txtMota) ;
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        textView.setText(TenLogo[i]);
        mota.setText(Mota[i]);
        imageView.setImageResource(hinhLogo[i]);
        return view;
    }
}
