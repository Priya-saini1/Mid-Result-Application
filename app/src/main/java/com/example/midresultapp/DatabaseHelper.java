package com.example.midresultapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="marks_record.db";
    public static final String TABLE_NAME="Student_marks";
    public static final String ID="ID";
    public static final String ENROLLMENT="ENROLLMENT";
    public static final String NAME="Student_NAME";
    public static final String SUBJECT="SUBJECT";
    public static final String MARKS="MARKS";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,ENROLLMENT TEXT,NAME TEXT,SUBJECT TEXT,MARKS TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
    public boolean insertData(String enrol,String Name,String subject,String marks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ENROLLMENT",enrol);
        contentValues.put("NAME",Name);
        contentValues.put("SUBJECT",subject);
        contentValues.put("MARKS",marks);
       long result= db.insert(TABLE_NAME,null,contentValues); //-->this method return -1 if record are not inserted
        if(result==-1)
                return false;
        else
            return true;

    }
    public Cursor getAllData(String Enroll){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + ENROLLMENT + "='" + Enroll + "'";
        Cursor res = db.rawQuery(query,null);
        return res;
    }
}
