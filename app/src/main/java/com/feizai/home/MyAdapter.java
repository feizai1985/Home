package com.feizai.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by feizai1985 on 2017/3/20.
 */
public class MyAdapter extends BaseAdapter {
    String[] items;
    int[] ints;
    Context mContext;
    public MyAdapter(Context mContext, String[] itmes, int[] ints) {
        super();
        this.items=itmes;
        this.ints=ints;
        this.mContext=mContext;
    }

    @Override
    public int getCount() {
        return ints.length;
    }

    @Override
    public Object getItem(int position) {
        return ints[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        if(convertView!=null){
            view=convertView;
        }else {
            view = View.inflate(mContext, R.layout.homeitems, null);
        }
        ImageView iv_home = (ImageView) view.findViewById(R.id.iv_home);
        iv_home.setBackgroundResource(ints[position]);
        TextView tv_home = (TextView) view.findViewById(R.id.tv_home);
        tv_home.setText(items[position]);
        return view;
    }
}
