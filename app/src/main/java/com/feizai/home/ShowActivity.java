package com.feizai.home;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {
    private Context mContext;
    private int type;
    private int position;
    private FrameLayout fl_show;
private String[] items;
    private int[] ints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        mContext=this;
        initUI();
        initData();
    }

    private void initData() {
        Bundle bundle = getIntent().getExtras();
        type = bundle.getInt("type");
        position = bundle.getInt("position");
        switch (type){
            case 0:
                items=ContentValues.JIAJUITEMS;
                ints=ContentValues.JIAJUINTS;
                show();
                break;
            case 1:
                items=ContentValues.JIARENITEMS;
                ints=ContentValues.JIARENINTS;
                show();
                break;
        }
    }

    private void initUI() {
        fl_show = (FrameLayout) findViewById(R.id.fl_show);
        findViewById(R.id.btn_pre).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pre();
            }
        });
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void show() {
        View inflate = View.inflate(mContext, R.layout.imageitmes, null);
        ImageView iv_home = (ImageView) inflate.findViewById(R.id.iv_main);
        iv_home.setBackgroundResource(ints[position]);
        TextView tv_home = (TextView) inflate.findViewById(R.id.tv_main);
        tv_home.setText(items[position]);
         fl_show.addView(inflate);
    }

    private void pre() {
        if(position==0){
            return;
        }

                View inflate = View.inflate(mContext, R.layout.imageitmes, null);
                ImageView iv_home = (ImageView) inflate.findViewById(R.id.iv_main);
                iv_home.setBackgroundResource(ints[position-1]);
                TextView tv_home = (TextView) inflate.findViewById(R.id.tv_main);
                tv_home.setText(items[position-1]);
        fl_show.removeAllViews();
                fl_show.addView(inflate);
        position=position-1;
    }
    private void next(){

        if(position==ints.length-1){
            return;
        }
        View inflate = View.inflate(mContext, R.layout.imageitmes, null);
        ImageView iv_home = (ImageView) inflate.findViewById(R.id.iv_main);
        iv_home.setBackgroundResource(ints[position+1]);
        TextView tv_home = (TextView) inflate.findViewById(R.id.tv_main);
        tv_home.setText(items[position+1]);
        fl_show.removeAllViews();
        fl_show.addView(inflate);
        position=position+1;
    }


}
