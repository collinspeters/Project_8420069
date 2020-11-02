package com.example.loginsignupform;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class WatchAdapter extends BaseAdapter {

    Context context;
    List<Watch> dataList;
    public ArrayList<Watch> orig;
    private View vi;
    private ViewHolder viewHolder;
    private static LayoutInflater inflater = null;
    DatabaseHelper1 db;

    public WatchAdapter(Context context, List<Watch> dataList){
        this.context = context;
        this.dataList = dataList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        db = new DatabaseHelper1(context);

    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        vi = view;
        //Populate the Listview
        final int pos = position;
        final Watch watch = dataList.get(pos);
        if(vi == null) {
            vi = inflater.inflate(R.layout.cell, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) vi.findViewById(R.id.watchnameTxt);
            viewHolder.info = (TextView) vi.findViewById(R.id.info);
            viewHolder.simpleImageView =(ImageView) vi.findViewById(R.id.simpleImageView);
            vi.setTag(viewHolder);
        }else
            viewHolder = (ViewHolder) view.getTag();

        viewHolder.name.setText(watch.getName());
        viewHolder.info.setText(watch.getInfo());

        viewHolder.simpleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = watch.getId();
                db.deleteData(String.valueOf(a));
                Intent intent = new Intent(context, DashAdmin.class);
                context.startActivity(intent);
                Toast.makeText(context,"Data has been deleted", Toast.LENGTH_SHORT).show();
            }
        });

        return vi;
    }



    public class ViewHolder{
        TextView name;
        TextView info;
        ImageView simpleImageView;
    }



    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

}