package com.testphase.list;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by deea on 07/12/15.
 */


public class DbHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "itemlist.db";

    public static final String ITEM_TABLE_NAME = "itemlist";
    public static final String ITEM_COLUMN_ID = "_id";
    public static final String ITEM_COLUMN_NAME = "name";
    public static final String ITEM_COLUMN_DESC = "description";


    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(
                "CREATE TABLE " + ITEM_TABLE_NAME +
                        "(" + ITEM_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        ITEM_COLUMN_NAME + " TEXT, " +
                        ITEM_COLUMN_DESC + " TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + ITEM_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertItem(String name, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ITEM_COLUMN_NAME, name);
        contentValues.put(ITEM_COLUMN_DESC, description);

        db.insert(ITEM_TABLE_NAME, null, contentValues);
        return true;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, ITEM_TABLE_NAME);
        return numRows;
    }

    public boolean updateItem(Integer id, String name, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ITEM_COLUMN_NAME, name);
        contentValues.put(ITEM_COLUMN_DESC, description);

        db.update(ITEM_TABLE_NAME, contentValues, ITEM_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) } );

        return true;
    }

    public Integer deleteItem(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(ITEM_TABLE_NAME,
                ITEM_COLUMN_ID + " = ? ",
                new String[] { Integer.toString(id) });
    }

    public Cursor getItem(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + ITEM_TABLE_NAME + " WHERE " +
                ITEM_COLUMN_ID + "=?", new String[]{Integer.toString(id)});
        return res;
    }

    public Cursor getAllItems(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + ITEM_TABLE_NAME, null);
        return res;
    }
}
