package com.example.loginsignupform;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper1 extends SQLiteOpenHelper
{
    Context context;
    public static String Databasename ="senior";
    public static String Table_Licen="Licence";
    public static String Table_addDish="Dish";
    public static String Table_Health="Health";
    public static String Table_Residence="residence";


    public static String id ="id";
    public static String editViewFirstName2 = "editViewFirstName2";
    public static String editViewLastName2 ="editViewLastName2";
    public static String editViewAddress2 ="editViewAddress2";
    public static String editViewDOB2 ="editViewDOB2";

    public static String id3 ="id3";
    public static String editViewFirstName3 = "editViewFirstName3";
    public static String editViewLastName3 ="editViewLastName3";
    public static String editViewAddress3 ="editViewAddress3";
    public static String editViewDOB3 ="editViewDOB3";


    public static String col1t_tfid1 ="id";
    public static String col2t_attributeTime2 = "Time";
    public static String col3t_attributeFood3 = "Food";
    public static String col4t_attributeAddress4 ="Address";
    public static String col5t_attributeCity5 ="City";
    public static String col6t_attributeaddress1 ="address1";
    public static String col7t_attributephone ="phone";

    public static String id1 ="id1";
    public static String editViewFirstName = "editViewFirstName";
    public static String editViewLastName ="editViewLastName";
    public static String editViewAddress ="editViewAddress";
    public static String editViewDOB ="editViewDOB";
    public static String editViewlicenseType ="editViewlicenseType";


    public DatabaseHelper1(Context context)
    {
        super(context, Databasename,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("create table "+Table_Licen+"(id1 INTEGER PRIMARY KEY, editViewFirstName TEXT,editViewLastName TEXT,editViewAddress TEXT,editViewDOB TEXT,editViewlicenseType TEXT)");
        sqLiteDatabase.execSQL("create table "+Table_addDish+"(id INTEGER PRIMARY KEY, Time TEXT,Food TEXT,Address TEXT,City TEXT,address1 TEXT,phone TEXT )");
        sqLiteDatabase.execSQL("create table "+Table_Health+"(id INTEGER PRIMARY KEY, editViewFirstName TEXT,editViewLastName TEXT,editViewAddress TEXT,editViewDOB TEXT)");
        sqLiteDatabase.execSQL("create table "+Table_Residence+"(id3 INTEGER PRIMARY KEY, editViewFirstName TEXT,editViewLastName TEXT,editViewAddress TEXT,editViewDOB TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("drop table if exists "+Table_Licen);

        sqLiteDatabase.execSQL("drop table if exists "+Table_addDish);

        sqLiteDatabase.execSQL("drop table if exists "+Table_Health);
        sqLiteDatabase.execSQL("drop table if exists "+Table_Residence);

    }


    //=====================================================================================

    public boolean insertDataResidence(String editViewFirstName, String editViewLastName,String editViewAddress, String editViewDOB)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(editViewFirstName2,editViewFirstName);
        cv.put(editViewLastName2,editViewLastName);
        cv.put(editViewAddress2,editViewAddress);
        cv.put(editViewDOB2,editViewDOB);


        long result = sqLiteDatabase.insert(Table_Residence,null,cv);
        if(result == -1)
        {
            return false;
        }
        return true;
    }
    public boolean insertDataHealth(String editViewFirstName, String editViewLastName,String editViewAddress, String editViewDOB)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(editViewFirstName2,editViewFirstName);
        cv.put(editViewLastName2,editViewLastName);
        cv.put(editViewAddress2,editViewAddress);
        cv.put(editViewDOB2,editViewDOB);


        long result = sqLiteDatabase.insert(Table_Health,null,cv);
        if(result == -1)
        {
            return false;
        }
        return true;
    }


    public boolean insertDataLice(String editViewFirstName, String editViewLastName,String editViewAddress, String editViewDOB,String editViewlicenseType)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(editViewFirstName,editViewFirstName);
        cv.put(editViewLastName,editViewLastName);
        cv.put(editViewAddress,editViewAddress);
        cv.put(editViewDOB,editViewDOB);
        cv.put(editViewlicenseType,editViewlicenseType);


        long result = sqLiteDatabase.insert(Table_Licen,null,cv);
        if(result == -1)
        {
            return false;
        }
        return true;
    }


    public boolean insertData1(String Time, String Food,String Address, String City,String address1,String phone)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col2t_attributeTime2,Time);
        cv.put(col3t_attributeFood3,Food);
        cv.put(col4t_attributeAddress4,Address);
        cv.put(col5t_attributeCity5,City);
        cv.put(col6t_attributeaddress1,address1);
        cv.put(col7t_attributephone,phone);


        long result = sqLiteDatabase.insert(Table_addDish,null,cv);
        if(result == -1)
        {
            return false;
        }
        return true;
    }


    //==========================================================================================
    public Cursor getData()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cr = sqLiteDatabase.rawQuery("select * from "+Table_addDish,null);
        return cr;
    }

   public Cursor getAllDataById(String attributeId)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cr = sqLiteDatabase.rawQuery("select * from "+Table_addDish+" where "+col3t_attributeFood3+"=?", new String[] {attributeId},null);
        return cr;
    }


    public boolean updateTeacherData(String Time, String Food,String Address, String City,String address1,String phone)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col2t_attributeTime2,Time);
        cv.put(col4t_attributeAddress4,Address);
        cv.put(col5t_attributeCity5,City);
        cv.put(col6t_attributeaddress1,address1);
        cv.put(col7t_attributephone,phone);

        db.update(Table_addDish, cv, "Food = ?",new String[] { Food });
        return true;
    }
    public void deleteData(String id)
    {
        int sqLiteDatabase = this.getWritableDatabase().delete(Table_addDish , col1t_tfid1 +"=?",new String[]{id});

    }

   /*
    public Cursor getAllDataById1(String attributeId)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cr = sqLiteDatabase.rawQuery("select * from "+Table_addDish+" where "+col6t_attributeState+"=?", new String[] {attributeId},null);
        return cr;
    }

    public Cursor getAllDataById2(String attributeId)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cr = sqLiteDatabase.rawQuery("select * from "+Table_addDish+" where "+col1t_tfid1+"=?", new String[] {attributeId},null);
        return cr;
    }*/
}

