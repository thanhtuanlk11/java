package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.TimeoutException;

public class AdapterMonAn extends BaseAdapter {

    private Context context;
    private int layout;
    private List<MonAn> arrayList;

    public AdapterMonAn(Context context, int layout, List<MonAn> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }


    @Override
    public int getCount() {
        return arrayList.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);

        MonAn monAn = arrayList.get(position);
        TextView text = convertView.findViewById(R.id.name);
        TextView text1 = convertView.findViewById(R.id.mota);
        TextView text2 = convertView.findViewById(R.id.init);
        ImageView image = convertView.findViewById(R.id.imageHinh);

        text.setText(monAn.getTemon());
        text1.setText(monAn.getMota());
        text2.setText(monAn.getGia());
        image.setImageResource(monAn.getHinh());
        return convertView;
    }
}
