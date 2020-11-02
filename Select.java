package com.example.loginsignupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class Select extends AppCompatActivity {
    private final static String JSON_FILE_ANDROID = "tutorial.json";
    private final static String TAG = "MainActivity";
    DatabaseHelper1 db = new DatabaseHelper1(this);
    Cursor cr;
    private WatchAdapter watchAdapter;
    private ListView listView1;
    Button addnew;
    ArrayList<Watch> watchslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        listView1 = (ListView) findViewById(R.id.listView);

        watchslist = new ArrayList<Watch>();
        init();

        addnew = (Button)findViewById(R.id.addnew);
        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Select.this,SignUP.class);
                startActivity(intent);
            }
        });
    }

    public void init() {
        cr = db.getData();
        while (cr.moveToNext())
        {
            Log.e("Tag1","===11==="+cr.getInt(0));
            Log.e("Tag1","===22==="+cr.getString(1));
            Log.e("Tag1","===33==="+cr.getString(2));
            Watch watch = new Watch(cr.getInt(0),cr.getString(1),cr.getString(4));
            watchslist.add(watch);
        }
        watchAdapter = new WatchAdapter(Select.this, watchslist);
        listView1.setAdapter(watchAdapter);
    }

}
