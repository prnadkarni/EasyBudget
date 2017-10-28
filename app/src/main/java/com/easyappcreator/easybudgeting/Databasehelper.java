package com.easyappcreator.easybudgeting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Expense.db";
    public static final String TABLE_NAME = "expense_table";
    public static final String COL1 = "ID";
    public static final String COL2 = "DATE";
    public static final String COL3 = "CATEGORY";
    public static final String COL4 = "DESCRIPTION";
    public static final String COL5 = "AMOUNT";

    public Databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, DATE TEXT, CATEGORY TEXT, DESCRIPTION TEXT, AMOUNT REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXSITS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String date, String category, String description, String amount) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,date);
        contentValues.put(COL3,category);
        contentValues.put(COL4,description);
        contentValues.put(COL5,amount);
        long result = sqLiteDatabase.insert(TABLE_NAME, null,contentValues );
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    //public Cursor getSumData() {
    public int getSumData()
    {
        int total = 0;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst())
        {
            total = cursor.getInt(0);
        }
        while (cursor.moveToNext());
        return total;
    }

    public int getRentSumData()
    {
        int totalRent = 0;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursorrent = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME +" WHERE " + COL3+"  = 'Rent/Utilities'", null );
        //Cursor cursorrent = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME, null);
        if (cursorrent.moveToFirst())
        {
            totalRent = cursorrent.getInt(0);
        }
        while (cursorrent.moveToNext());
        return totalRent;
    }

    public int getEntSumData()
    {
        int totalEnt = 0;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursorent = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME +" WHERE " + COL3+"  = 'Entertainment'", null );
        //Cursor cursorrent = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME, null);
        if (cursorent.moveToFirst())
        {
            totalEnt = cursorent.getInt(0);
        }
        while (cursorent.moveToNext());
        return totalEnt;
    }

    public int getClothesSumData()
    {
        int totalClothes = 0;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursorclothes = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME +" WHERE " + COL3+"  = 'Clothes'", null );
        //Cursor cursorrent = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME, null);
        if (cursorclothes.moveToFirst())
        {
            totalClothes = cursorclothes.getInt(0);
        }
        while (cursorclothes.moveToNext());
        return totalClothes;
    }

    public int getPurchasesSumData()
    {
        int totalPurchases = 0;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursorpurchases = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME +" WHERE " + COL3+"  = 'New Purchases'", null );
        //Cursor cursorrent = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME, null);
        if (cursorpurchases.moveToFirst())
        {
            totalPurchases = cursorpurchases.getInt(0);
        }
        while (cursorpurchases.moveToNext());
        return totalPurchases;
    }

    public int getGasSumData()
    {
        int totalGas = 0;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursorgas = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME +" WHERE " + COL3+"  = 'Gas/Car Utilities'", null );
        //Cursor cursorrent = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME, null);
        if (cursorgas.moveToFirst())
        {
            totalGas = cursorgas.getInt(0);
        }
        while (cursorgas.moveToNext());
        return totalGas;
    }

    public int getTuitionSumData()
    {
        int totalTuition = 0;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursortuition = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME +" WHERE " + COL3+"  = 'Tuition/Books'", null );
        //Cursor cursorrent = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME, null);
        if (cursortuition.moveToFirst())
        {
            totalTuition = cursortuition.getInt(0);
        }
        while (cursortuition.moveToNext());
        return totalTuition;
    }

    public int getFoodSumData()
    {
        int totalFood = 0;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursorfood = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME +" WHERE " + COL3+"  = 'Food/Groceries'", null );
        //Cursor cursorrent = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME, null);
        if (cursorfood.moveToFirst())
        {
            totalFood = cursorfood.getInt(0);
        }
        while (cursorfood.moveToNext());
        return totalFood;
    }

    public int getOtherSumData()
    {
        int totalOther = 0;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursorother = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME +" WHERE " + COL3+"  = 'Other'", null );
        //Cursor cursorrent = sqLiteDatabase.rawQuery("SELECT SUM(" + COL5 +") FROM " + TABLE_NAME, null);
        if (cursorother.moveToFirst())
        {
            totalOther = cursorother.getInt(0);
        }
        while (cursorother.moveToNext());
        return totalOther;
    }

    //SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
    //Cursor sumres = sqLiteDatabase.rawQuery("SELECT SUM("+ COL4 + " ) FROM "+ TABLE_NAME,null);
    //if (sumres !=null) {
    //    sumres.moveToFirst();
    //}
    //return sumres;
    //}

    public void deleteAll()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM "+ TABLE_NAME);
        //sqLiteDatabase.delete("TABLE_NAME", null,null);
        //drop table if exists "TABLE_NAME"
        //db.execSQL("TRUNCATE table" + TABLE_NAME);
        sqLiteDatabase.close();
    }


}
