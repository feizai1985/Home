package com.feizai.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import static com.feizai.home.ContentValues.*;

public class ItemActivity extends AppCompatActivity {
private Context mContext;
    private GridView gv_item;
    private int type;
private String[] itmes;
    private int[] ints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        mContext=this;

        initData();
        initUI();
    }

    private void initData() {
        Bundle bundle = getIntent().getExtras();
        type = bundle.getInt("type");
        typeIsWhat(type);
    }

    private void typeIsWhat(int type) {
        switch (type){
            case 0 :
                itmes=ContentValues.JIAJUITEMS;
                ints=ContentValues.JIAJUINTS;
                break;

            case 3 :
                itmes=ContentValues.JIARENITEMS;
                ints=ContentValues.JIARENINTS;
                break;
            case 4 :
                itmes=ContentValues.TOUXIANGITEMS;
                ints=ContentValues.TOUXIANGINTS;
                break;
            case 5 :
                itmes=ContentValues.BAOBAOITEMS;
                ints=ContentValues.BAOBAOINTS;
                break;
            case 6 :
                itmes=ContentValues.CARITEMS;
                ints=ContentValues.CARINTS;
                break;
            case 7 :
                itmes=ContentValues.JIEITEMS;
                ints=ContentValues.JIEINTS;
                break;
        }
    }

    private void initUI() {
        gv_item = (GridView) findViewById(R.id.gv_item);
        gv_item.setAdapter(new MyAdapter(mContext,itmes, ints));
        gv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
                Intent intent = new Intent(mContext, ShowActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("type",type);
                bundle.putInt("position",position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        gv_item=null;
        finish();
        Intent intent = new Intent(mContext, HomeActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
