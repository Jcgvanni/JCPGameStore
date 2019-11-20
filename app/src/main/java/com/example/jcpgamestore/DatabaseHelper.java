package com.example.jcpgamestore;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "jcpstore.db";

    public static final String TABLE1NAME = "users_table";
    public static final String COLTB1_1 = "USERID";
    public static final String COLTB1_2 = "FULLNAME";
    public static final String COLTB1_3 = "EMAIL";
    public static final String COLTB1_4 = "ADDRESS";
    public static final String COLTB1_5 = "PASSWORD";

    public static final String TABLE2NAME = "games_table";
    public static final String COLTB2_1 = "GAMEID";
    public static final String COLTB2_2 = "NAME";
    public static final String COLTB2_3 = "PRICE";

    public static final String TABLE3NAME = "cart_table";
    public static final String COLTB3_1 = "USERID";
    public static final String COLTB3_2 = "GAMEID";
    public static final String COLTB3_3 = "NAME";
    public static final String COLTB3_4 = "PRICE";






    public DatabaseHelper(@Nullable Context context) {
        super(context, DBNAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE1NAME
                + " (USERID INTEGER PRIMARY KEY AUTOINCREMENT, FULLNAME TEXT, EMAIL TEXT, ADDRESS TEXT, PASSWORD TEXT)");
        db.execSQL("CREATE TABLE " + TABLE2NAME
                + " (GAMEID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PRICE DECIMAL)");
        db.execSQL("CREATE TABLE " + TABLE3NAME
                + " (USERID INTEGER, GAMEID INTEGER, NAME TEXT, PRICE DECIMAL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE1NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE2NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE3NAME);
        onCreate(db);

    }
    public boolean addUserData (String fullname, String email, String address, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(COLTB1_2, fullname);
        val.put(COLTB1_3, email);
        val.put(COLTB1_4, address);
        val.put(COLTB1_5, password);
        long result = db.insert(TABLE1NAME, null, val);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void addGameData (String name, double price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(COLTB2_2, name);
        val.put(COLTB2_3, price);


    }
    /* don't know how to implement automatic
    public boolean addCartData (String userid, String gameid, String name, double price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
    }*/
}
