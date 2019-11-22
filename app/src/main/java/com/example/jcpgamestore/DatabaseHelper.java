package com.example.jcpgamestore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.jcpgamestore.model.DataGame;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    private Context context;

    public static final String DBNAME = "jcpstore.db";

    public static final String USERS_TABLE = "users";
    public static final String USERID = "id";
    public static final String FULLNAME = "fullname";
    public static final String EMAIL = "email";
    public static final String ADDRESS = "address";
    public static final String PASSWORD = "password";

    public static final String PRODUCTS_TABLE = "products";
    public static final String PRODUCTID = "id";
    public static final String NAME = "name";
    public static final String PRICE = "price";
    public static final String IMAGE = "image";

    public static final String CARTS_TABLE = "carts";
//    public static final String CARTID = "cartid";
    public static final String CART_USERID = "userid";
    public static final String CART_GAMEID = "gameid";
    public static final String QUANTITY = "quantity";


    private static DatabaseHelper sInstance;

    public static synchronized DatabaseHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }


    /**
     * Constructor should be private to prevent direct instantiation.
     * Make a call to the static method "getInstance()" instead.
     */
    private DatabaseHelper(@Nullable Context context) {
        super(context, DBNAME, null, 1);
        this.context = context;
        this.db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + USERS_TABLE
                + "(" + USERID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FULLNAME + " TEXT," +
                EMAIL + " TEXT, " +
                ADDRESS + " TEXT, " +
                PASSWORD + " TEXT)");

        db.execSQL("CREATE TABLE " + PRODUCTS_TABLE
                + " (" + PRODUCTID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME +" TEXT, " +
                IMAGE +" INTEGER, " +
                PRICE +" DECIMAL)");

        db.execSQL("CREATE TABLE " + CARTS_TABLE
                + " ("+CART_USERID+" INTEGER, " +
                CART_GAMEID +" INTEGER, " +
                QUANTITY + " INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE );
        db.execSQL("DROP TABLE IF EXISTS " + PRODUCTS_TABLE );
        db.execSQL("DROP TABLE IF EXISTS " + CARTS_TABLE );
        onCreate(db);

    }
    public boolean addUserData (String fullname, String email, String address, String password){
        ContentValues val = new ContentValues();
        val.put( FULLNAME, fullname);
        val.put( EMAIL, email);
        val.put( ADDRESS, address);
        val.put( PASSWORD, password);
        long result = db.insert( USERS_TABLE, null, val);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * Adds a new product on DB.
     * @param name
     * @param price
     * @param image
     */
    public void addProduct(String name, double price, Integer image){
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put( NAME, name);
            values.put( PRICE, price);
            values.put( IMAGE, image);

            db.insertOrThrow(PRODUCTS_TABLE, null, values);
        } catch (Exception e) {
            Log.e("Error adding DB", e.getMessage());
        }
    }

    public List<DataGame> loadGames(){

        List<DataGame> products = new ArrayList<>(  );
        String query = "Select " +
                PRODUCTID +", " +
                NAME + ", " +
                PRICE + ", "+
                IMAGE +
                " FROM " + PRODUCTS_TABLE;

        try {
            SQLiteDatabase db = getReadableDatabase();

            Cursor cursor = db.rawQuery(query,null);
            if (cursor != null){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    DataGame product = new DataGame();

                    product.setId(cursor.getInt(cursor.getColumnIndex(PRODUCTID)));
                    product.setGameName( cursor.getString( cursor.getColumnIndex(NAME)));
                    product.setPrice( cursor.getDouble( cursor.getColumnIndex( PRICE ) ) );
                    product.setImage( cursor.getInt( cursor.getColumnIndex( IMAGE ) ) );

                    products.add( product );
                    cursor.moveToNext();
                }
            }
        } catch (Exception ex){
            Log.e("DB DEMO", ex.getMessage());
        }

        return products;
    }



    /* don't know how to implement automatic
    public boolean addCartData (String userid, String gameid, String name, double price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
    }*/
}
