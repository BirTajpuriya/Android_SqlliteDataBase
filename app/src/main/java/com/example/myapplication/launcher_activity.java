package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.utilities.DbHandler;

public class launcher_activity extends AppCompatActivity {
Button viewBtn,addBtn;
EditText name, passmarks, fullmarks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        viewBtn=findViewById(R.id.viewBtn);
        addBtn=findViewById(R.id.addBtn);
        name=findViewById(R.id.name);
        passmarks=findViewById(R.id.passmarks);
        fullmarks=findViewById(R.id.fullmarks);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbHandler sqLiteDatabase=new DbHandler(getApplicationContext());
               // sqLiteDatabase.hello();
             sqLiteDatabase.addItem(name.getText().toString(), Integer.valueOf(passmarks.getText().toString()),Integer.valueOf(fullmarks.getText().toString()));
            }
        });
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}