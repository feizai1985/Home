package com.feizai.home;

import android.content.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;

import android.widget.GridView;


public class HomeActivity extends AppCompatActivity {

    private GridView gv_hme;

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mContext=this;

        iniUI();

    }



    private void iniUI() {
        gv_hme = (GridView) findViewById(R.id.gv_hme);
        gv_hme.setAdapter(new MyAdapter(mContext, ContentValues.HOMEITEMS,ContentValues.HOMEINTS));
        gv_hme.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        Intent intent=new Intent(mContext,ItemActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("type",0);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                    case 1:

                        Intent intent1=new Intent(mContext,ItemActivity.class);
                        Bundle bundle1 = new Bundle();
                        bundle1.putInt("type",1);
                        intent1.putExtras(bundle1);
                        startActivity(intent1);
                        break;

                    case 2:

                        Intent intent2=new Intent(mContext,ItemActivity.class);
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("type",2);
                        intent2.putExtras(bundle2);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3=new Intent(mContext,ItemActivity.class);
                        Bundle bundle3 = new Bundle();
                        bundle3.putInt("type",3);
                        intent3.putExtras(bundle3);
                        startActivity(intent3);
                }

            }
        });
    }


}
