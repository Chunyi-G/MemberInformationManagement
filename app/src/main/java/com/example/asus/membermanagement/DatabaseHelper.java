package com.example.asus.membermanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.asus.membermanagement.CustomerInformation.*;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "CustomerInformation.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + CustomerInformationEntry.TABLE_NAME + " (" +
                CustomerInformationEntry.COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CustomerInformationEntry.COL_2 + " TEXT, " +
                CustomerInformationEntry.COL_3 + " TEXT, " +
                CustomerInformationEntry.COL_4 + " TEXT, " +
                CustomerInformationEntry.COL_5 + " TEXT, " +
                CustomerInformationEntry.COL_6 + " TEXT, " +
                CustomerInformationEntry.COL_7 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CustomerInformationEntry.TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String fName, String lName, String contactNo, String email, String memberType, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CustomerInformationEntry.COL_2, fName);
        contentValues.put(CustomerInformationEntry.COL_3, lName);
        contentValues.put(CustomerInformationEntry.COL_4, contactNo);
        contentValues.put(CustomerInformationEntry.COL_5, email);
        contentValues.put(CustomerInformationEntry.COL_6, memberType);
        contentValues.put(CustomerInformationEntry.COL_7, address);
        long result = db.insert(CustomerInformationEntry.TABLE_NAME, null, contentValues);

        if (result == -1)
            return false;
        else
            return true;
    }
}
