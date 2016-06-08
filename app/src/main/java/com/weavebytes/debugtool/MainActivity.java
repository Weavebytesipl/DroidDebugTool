package com.weavebytes.debugtool;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener{

    Button   btnshow,share;
    String   TAG = "MainActivity";
    int DivideIt;
    int result;
    ListView listView;
    Button clear;
    ArrayAdapter ad;
    String path ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // txtmessage = (TextView)findViewById(R.id.txtmsg);
        share      = (Button)   findViewById (R.id.btnshare);
        btnshow    = (Button)   findViewById (R.id.btnShow);
        listView   = (ListView) findViewById (R.id.list);
        clear = (Button) findViewById(R.id.btnclear);
        btnshow.setOnClickListener(this);
        share.setOnClickListener(this);
        clear.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnShow:
                try {
                     result = DivideIt/0;
                }catch (ArithmeticException e){

                    Config.DEBUG_LOG_STRING=e.toString();
                    Config.DEBUG_TOAST_STRING+=e.toString();
                    FileLogger.appendLog("ArithmeticException :: "+e.toString());
                }
                Config.ERROR_LIST.add(Config.DEBUG_LOG_STRING);
                try {
                    File file = new File(path);

                }catch (NullPointerException e){
                    Config.DEBUG_LOG_STRING=e.toString();
                    Config.DEBUG_TOAST_STRING+=e.toString();
                    FileLogger.appendLog("NullPointerException :: "+e.toString());
                }
                   Config.ERROR_LIST.add(Config.DEBUG_LOG_STRING);
                ad= new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,Config.ERROR_LIST);
                listView.setAdapter(ad);
                Config.showToast(MainActivity.this);
                Config.showLog(TAG);
               // txtmessage.setText(Config.DEBUG_LOG_STRING);
                break;

            case R.id.btnshare:

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/html");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(String.valueOf(Config.ERROR_LIST)));
                startActivity(Intent.createChooser(sharingIntent,"Share using"));
                break;
            case R.id.btnclear:

                Config.ERROR_LIST.clear();
                ad.notifyDataSetChanged();
                Config.DEBUG_LOG_STRING = null;
                Config.DEBUG_TOAST_STRING = null;
                break;

        }

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent it = new Intent(MainActivity.this,DetailsActivity.class);
        it.putExtra("position",position);
        startActivity(it);
    }
}
