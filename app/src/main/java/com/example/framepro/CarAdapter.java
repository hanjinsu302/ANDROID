package com.example.framepro;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Car> mData;

    public  CarAdapter(Context mContext, ArrayList<Car> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }




    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView=View.inflate(mContext, R.layout.listitem,null);
        }
        ImageView image=(ImageView) convertView.findViewById(R.id.imgPoster);
        TextView title=convertView.findViewById(R.id.txtTitle);
        TextView genre=convertView.findViewById(R.id.txtGenre);

        image.setImageDrawable(mData.get(position).image);
        title.setText(mData.get(position).title);
        genre.setText(mData.get(position).genre);

        return convertView;
    }






}