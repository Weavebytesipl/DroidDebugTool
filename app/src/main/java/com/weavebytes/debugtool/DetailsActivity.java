package com.weavebytes.debugtool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    int position;
    TextView detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent it = getIntent();
        position = it.getIntExtra("position",0);


        detail = (TextView)findViewById(R.id.txtdetail);
        detail.setText(Config.ERROR_LIST.get(position));
    }
}
