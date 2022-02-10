package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Adapters.CustomAdapter;
import com.example.myapplication.utilities.DbHandler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycleView;
    DbHandler db;
    ArrayList<String> id, name, passmark, fullmark;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleView = findViewById(R.id.recycleView);
        db = new DbHandler(MainActivity.this);
        id = new ArrayList<>();
        name = new ArrayList<>();
        passmark = new ArrayList<>();
        fullmark = new ArrayList<>();
        storeDataInArrays();
        customAdapter=new CustomAdapter(this,id,name,passmark,fullmark);
        recycleView.setAdapter(customAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    void storeDataInArrays() {
        Cursor cursor = db.getalldata();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                passmark.add(cursor.getString(2));
                fullmark.add(cursor.getString(3));
            }
        }
    }
}