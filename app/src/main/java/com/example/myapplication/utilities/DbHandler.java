package com.example.myapplication.utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "student.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "subject";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "stu_name";
    private static final String COLUMN_PASS_MARKS = "stu_pass";
    private static final String COLUMN_FULL_MARKS = "stu_fullmarks";


    public DbHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query =  " CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT NOT NULL, " +
                COLUMN_PASS_MARKS + " INTEGER NOT NULL, " +
                COLUMN_FULL_MARKS + " INTEGER NOT NULL);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public void addItem(String name, int passmarks, int fullmarks) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME,name);
        cv.put(COLUMN_PASS_MARKS,passmarks);
        cv.put(COLUMN_FULL_MARKS,fullmarks);
        long result =sqLiteDatabase.insert(TABLE_NAME,null ,cv);
        if(result==-1){
            Toast.makeText(context, "Failed to insert", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Add successfully", Toast.LENGTH_SHORT).show();
            
        }
        
    }
    public void hello(){
        System.out.printf("hello this is android");
    }

    public Cursor getalldata(){
        String query= " SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=null;
        if(db!=null){
            cursor=db.rawQuery(query,null);
        }
        return cursor;
    }


}
