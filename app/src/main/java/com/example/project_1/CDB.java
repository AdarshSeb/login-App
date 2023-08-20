package com.example.project_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DMS";
    public CDB(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table users (uname varchar(20) primary key , upass varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
        onCreate(sqLiteDatabase);
    }

    public void adduser(String uname,String upass){
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("uname",uname);
            cv.put("upass",upass);
            db.insert("users",null,cv);
            db.close();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public String[] getuser(String uname){
        String a[] = new String[2];
        try
        {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query("users",new String[]{"uname","upass"},"uname"+"=?",new String[]{uname},null,null,null,null);
            if(cursor != null && cursor.getCount() != 0){
                cursor.moveToFirst();
                a[0] = cursor.getString(0);
                a[1] = cursor.getString(1);
            }
            else{
                a[0] = "";
                a[1] = "";
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return a;
    }

    public void updatePassword(String uname,String usernp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("uname",uname);
        cv.put("upass",usernp);
        db.update("users",cv,"uname =?",new String[]{uname});
        db.close();
    }
}
