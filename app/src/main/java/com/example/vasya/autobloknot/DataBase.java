package com.example.vasya.autobloknot;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends Activity {
    DbHelper dbHelper;
    SQLiteDatabase db;


    public DataBase(Context context){
        dbHelper = new DbHelper(context);
    }

    public Cursor getAllItemAZS(){
        db = dbHelper.getReadableDatabase();
        return (db.query("oil", null, null, null, null, null, null));
    }
    public Cursor getAllItemSTO(){
        db = dbHelper.getReadableDatabase();
        return (db.query("sto", null, null, null, null, null, null));
    }

    public void delRecAZS(long id) {
        db = dbHelper.getWritableDatabase();
        db.delete("oil", "_id = " + id, null);

    }
    public void delRecSTO(long id) {
        db = dbHelper.getWritableDatabase();
        db.delete("sto", "_id = " + id, null);
    }

    public void  Close(){
        if(dbHelper != null){dbHelper.close();};
        if(db != null){db.close();};
    }

      public class DbHelper extends SQLiteOpenHelper {
        public DbHelper(Context context) {
            super(context, "Bloknot", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table oil(" + "_id integer primary key autoincrement,"
            + "data varchar(255)," + "suma varchar(255)," + "price varchar(255),"
            + "count varchar(255)," + "probeg varchar(255)" + ");");
            db.execSQL("create table sto(" + "_id integer primary key autoincrement,"
            + "data varchar(255)," + "suma varchar(255)," + "desc text" + ");");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
