package com.tiztrain.viewerwmsrepository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by tiztrain on 14-Jan-18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "WMS.db";
    public static final String TABLE_NAME = "WMS_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "titleWMS";
    public static final String COL_3 = "urlWMS";
    public static final String COL_4 = "serviceWMS";
    public static final String COL_5 = "versionWMS";
    public static final String COL_6 = "requestWMS";
    public static final String COL_7 = "layerWMS";
    public static final String COL_8 = "bboxWMS";
    public static final String COL_9 = "widthWMS";
    public static final String COL_10 = "heightWMS";
    public static final String COL_11 = "projectionWMS";
    public static final String COL_12 = "imgFormatWMS";
    public static final String COL_13 = "transparentWMS";
    public static final String COL_14 = "stylesWMS";
    public static final String COL_15 = "compUrlWMS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String SQL_String = "CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT," + COL_3 + " TEXT," + COL_4 + " TEXT"+
//                ", UNIQUE(" + COL_3 + ")" + " ON CONFLICT ABORT" + ")";
        String SQL_String = "CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_2 + " TEXT," + COL_3 + " TEXT UNIQUE," + COL_4 + " TEXT,"
                + COL_5 + " TEXT," + COL_6 + " TEXT," + COL_7 + " TEXT,"
                + COL_8 + " TEXT," + COL_9 + " TEXT," + COL_10 + " TEXT,"
                + COL_11 + " TEXT," + COL_12 + " TEXT," + COL_13 + " TEXT,"
                + COL_14 + " TEXT, " + COL_15 + " TEXT UNIQUE)";
        db.execSQL(SQL_String);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Not needed
//    public void insertData(String title, String url, String type){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_2, title);
//        contentValues.put(COL_3, url);
//        contentValues.put(COL_4, type);
////        db.insert(TABLE_NAME, null, contentValues);
//        db.insertWithOnConflict(TABLE_NAME, null, contentValues, SQLiteDatabase.CONFLICT_ABORT);
//    }

    public void insertData(int id, String title, String compUrlWMS){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
//        String compUrlWMS = COL_2 + COL_3 + COL_4 + COL_5 + COL_6 + COL_7 + COL_8 +
////                COL_9 + COL_10 + COL_11 + COL_12 + COL_13 + COL_14;
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, title);
        contentValues.put(COL_3, compUrlWMS);
        db.insert(TABLE_NAME, null, contentValues);
        //db.insertWithOnConflict(TABLE_NAME, null, contentValues, SQLiteDatabase.CONFLICT_ABORT);
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_NAME, null);
        return result;
    }

    //Searches if the input from the textview matches any ID numbers from the list the scroll view
    public int listWMS(int input){
        int result = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                new String[] {COL_1},
                COL_1 + " = " + input,
                null, null, null, null);
        //This is to stop the code from having indexing errors or issues with have an empty cursor
        if(cursor  != null && cursor.moveToFirst()) {
            result = cursor.getInt(cursor.getColumnIndex(COL_1));
            cursor.close();
        }
        return result;
    }

    //Not needed
//    public boolean isRecordExistInDatabase(String tableName, String field, String value) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "SELECT * FROM " + tableName + " WHERE " + field + " = '" + value + "'";
//        Cursor c = db.rawQuery(query, null);
//        if (c.moveToFirst()) {
//            //Record exist
//            c.close();
//            return true;
//        }
//        //Record available
//        c.close();
//        return false;
//    }

    public void clearDatabase(String TABLE_NAME) {
        SQLiteDatabase db = this.getWritableDatabase();
        String clearDBQuery = "DELETE FROM "+TABLE_NAME;
        db.execSQL(clearDBQuery);
    }

    public void deleteDatabase(String TABLE_NAME){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE Name = '" + TABLE_NAME + "'");
    }


}
