package com.example.rndroid.sqlite_ex2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rndroid on 30/12/16.
 */

public class MyDatabase {
    SQLiteDatabase sqLiteDatabase;
    MySQLite_Helper helper;

    public MyDatabase(Context c){
        helper = new MySQLite_Helper(c,"mydatabase.db", null,1);
    }

    public void openDB(){
        sqLiteDatabase = helper.getWritableDatabase();
    }
    public void closeDB(){
        sqLiteDatabase.close();
    }

    // insert employe details
    public void insert(String name, String sal, String dname){
        ContentValues values = new ContentValues();
        values.put("emane", name);
        values.put("esal", sal);
        switch (dname){
            case "training" : values.put("dno", "1");break;
            case "placement" : values.put("dno", "2");break;
            case "sales" : values.put("dno", "3");break;
        }
        sqLiteDatabase.insert("empDetail", null, values);

    }

    // get employee name according to dept name
    public Cursor getEmployeeName(String ename/*, String edept*/){
        Cursor c = null;
        c = sqLiteDatabase.query("empDetail", null,"ename=?",new String[]{ename},null,null,null);
        return c;
    }

    //update salary of employee
    public void updateEmpSal(String esal){
        ContentValues values = new ContentValues();
        values.put("esal", esal);
        sqLiteDatabase.insert("empDetail", null, values);
    }

    public class MySQLite_Helper extends SQLiteOpenHelper{

        public MySQLite_Helper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            sqLiteDatabase.execSQL("create table empDetail (_id integer primary key, ename text not null, esal text not null, dno text);");
        }
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
