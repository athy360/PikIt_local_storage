package com.example.athyab.pikit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELL on 4/14/2017.
 */

//class for handling the database

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME= "Register.db";
    public static final String TABLE_NAME="register_table";
    public static final String COLUMN_1= "id";
    public static final String COLUMN_2= "fullname";
    public static final String COLUMN_3= "email";
    public static final String COLUMN_4= "password";

    //creating a table inside the db
    public DBHelper(Context context) {
        super(context,DB_NAME , null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " +TABLE_NAME +" ( "+ COLUMN_1+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_2+" TEXT, "+COLUMN_3+" TEXT, "+COLUMN_4+" TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }


    // storing new registration details
    public boolean insertRegisterData(User u){
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COLUMN_2, u.getFullname());
        contentValues.put(COLUMN_3, u.getEmail());
        contentValues.put(COLUMN_4, u.getPassword());
        long result= sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (result==-1) {
            sqLiteDatabase.close();
            return false;
        }else {
            sqLiteDatabase.close();
            return true;
        }
    }

    public String searchPass(String email) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "select * from " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        String e1, p1;
        p1 = "not found";
        if (cursor.moveToFirst()) {
            do {
                e1 = cursor.getString(0);
                if (e1.equals(email)) {
                    p1 = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());
        }
            return p1;
    }
//check if password and username matches
    public boolean getAllTags(String a, String b) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor c =sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " where "+COLUMN_3+" = '" +a + "' AND "+COLUMN_4+" = '"+b+"' " , null);

        if(c.getCount() <= 0){
            c.close();
            return false;
        }
        c.close();
        return true;

    }


}
