package com.example.app4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "people.db";
    public static final String TABLE_NAME = "people_table";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Surname";
    public static final String COL_4 = "Age";

    public DatabaseHelper( Context context) {
        super( context, DATABASE_NAME, null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE " + TABLE_NAME + " (" + COL_1+ " INTEGER PRIMARY KEY , " + COL_2 + " TEXT NOT NULL, " + COL_3 + " TEXT NOT NULL, " + COL_4 + " TEXT NOT NULL) " );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS "+ TABLE_NAME );
        onCreate( db );
    }

    public boolean insertData( String id, String name, String surname, String age) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(  );
        contentValues.put( COL_1, id );
        contentValues.put( COL_2, name );
        contentValues.put( COL_3, surname );
        contentValues.put( COL_4, age );
        long result = db.insert(TABLE_NAME, null, contentValues );
        return result != -1;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME , null);
        return res ;
    }

    public boolean updateData(String id, String name, String surname, String age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(  );
        contentValues.put( COL_1, id );
        contentValues.put( COL_2, name );
        contentValues.put( COL_3, surname );
        contentValues.put( COL_4, age );
        db.update( TABLE_NAME, contentValues, " ID = ?", new String [] {id} );
        return true;
    }

    /*public Integer deleteData(String name){
        SQLiteDatabase db = this.getWritableDatabase();

       // return db.delete(  TABLE_NAME, COL_2 + "=?", new String[]  {name});
        Integer x = this.getWritableDatabase().delete( TABLE_NAME, "Name=' "+name+" '", null);
        return x;*/

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }
    }

