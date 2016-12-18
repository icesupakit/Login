package com.example.login.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by icesupakit on 12/18/2016.
 */

public class DatabaseHelper  extends SQLiteOpenHelper {
    private static final String TAG = DatabaseHelper.class.getSimpleName();


    private static final String DATABASE_NAME = "Login_to_DB.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "UserList";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_Use = "Usename";
    public static final String COL_Pass = "Password";


    private static final String SQL_CRATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NAME + " TEXT, "
                    + COL_Use + " TEXT, "
                    + COL_Pass + " TEXT"

                    + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CRATE_TABLE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, "Android Studio");
        cv.put(COL_Use, "Android");
        cv.put(COL_Use, "123456");
        db.insert(TABLE_NAME, null, cv);
        Log.i(TAG,"เข้าแล้วนะ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

}
