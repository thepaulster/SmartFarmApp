package national.org.smartfarm.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import national.org.smartfarm.model.FarmList;

/**
 * Created by Owner on 11/26/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private  DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "SmartFarm.db";


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_FAVORITE_TABLE = "CREATE TABLE " + BeneficiaryContract.BeneficiaryEntry.TABLE_NAME + " (" +
                BeneficiaryContract.BeneficiaryEntry._ID + " TEXT NOT NULL," +
                BeneficiaryContract.BeneficiaryEntry.COLUMN_CHICKEN_SOLD + " INTEGER NOT NULL, " +
                BeneficiaryContract.BeneficiaryEntry.COLUMN_CHICKS_SOLD + " INTEGER NOT NULL, " +
                BeneficiaryContract.BeneficiaryEntry.COLUMN_EGGS_SOLD + " INTEGER NOT NULL, " +
//                BeneficiaryContract.BeneficiaryEntry.COLUMN_CHICKEN_DEATHS + " INTEGER NOT NULL " +
//                BeneficiaryContract.BeneficiaryEntry.COLUMN_VACCINES + " INTEGER NOT NULL, " +
//                BeneficiaryContract.BeneficiaryEntry.COLUMN_FEEDS + " INTEGER NOT NULL, " +
//                BeneficiaryContract.BeneficiaryEntry.COLUMN_EGGS_COLLECTED + " INTEGER NOT NULL " +
//                BeneficiaryContract.BeneficiaryEntry.COLUMN_EGGS_HATCHED + " INTEGER NOT NULL, " +
//                BeneficiaryContract.BeneficiaryEntry.COLUMN_CHICKEN_VACCINATED + " INTEGER NOT NULL, " +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_FAVORITE_TABLE);
    }
    //drop beneficiary table
    private String DROP_BENEFICIARY_TABLE = "DROP TABLE IF EXISTS " + BeneficiaryContract.BeneficiaryEntry.TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    //---opens the database---
    public DatabaseHelper open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }


    //---closes the database---
    public void close()
    {
        DBHelper.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db1, int oldVersion, int newVersion) {

        //Drop User Table if exist

        db1.execSQL(DROP_BENEFICIARY_TABLE);

        // Create tables again
        onCreate(db1);

    }


    //Method to create beneficiary records

    public void addBeneficiary(FarmList farmList) {
        SQLiteDatabase db = this.getWritableDatabase();
//
        ContentValues values = new ContentValues();
        values.put(BeneficiaryContract.BeneficiaryEntry._ID, farmList.getId());


        values.put(BeneficiaryContract.BeneficiaryEntry.COLUMN_CHICKEN_SOLD, farmList.getChickenSold());
        values.put(BeneficiaryContract.BeneficiaryEntry.COLUMN_CHICKS_SOLD, farmList.getChicksSold());
        values.put(BeneficiaryContract.BeneficiaryEntry.COLUMN_EGGS_SOLD, farmList.getEggsSold());
////        values.put(BeneficiaryContract.BeneficiaryEntry.COLUMN_CHICKEN_DEATHS, farmList.getCountry());
////        values.put(BeneficiaryContract.BeneficiaryEntry.COLUMN_VACCINES, farmList.getAddress());
////        values.put(BeneficiaryContract.BeneficiaryEntry.COLUMN_FEEDS, farmList.getCountry());
////        values.put(BeneficiaryContract.BeneficiaryEntry.COLUMN_EGGS_COLLECTED, farmList.getAddress());
////        values.put(BeneficiaryContract.BeneficiaryEntry.COLUMN_EGGS_HATCHED, farmList.getCountry());
////        values.put(BeneficiaryContract.BeneficiaryEntry.COLUMN_CHICKEN_VACCINATED, farmList.getCountry())
//
        db.insert(BeneficiaryContract.BeneficiaryEntry.TABLE_NAME, null,values);
        db.close();
    }

//    public boolean checkUser(String email) {

//        // array of columns to fetch
//        String[] columns = {
//                BeneficiaryContract.BeneficiaryEntry._ID
//        };
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        // selection criteria
//        String selection = BeneficiaryContract.BeneficiaryEntry.COLUMN_BENEFICIARY_EMAIL + " = ?";
//
//        // selection argument
//        String[] selectionArgs = {email};
//
//        // query user table with condition
//        /**
//         * Here query function is used to fetch records from user table this function works like we use sql query.
//         * SQL query equivalent to this query function is
//         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
//         */
//        Cursor cursor = db.query(BeneficiaryContract.BeneficiaryEntry.TABLE_NAME, //Table to query
//                columns,                    //columns to return
//                selection,                  //columns for the WHERE clause
//                selectionArgs,              //The values for the WHERE clause
//                null,                       //group the rows
//                null,                      //filter by row groups
//                null);                      //The sort order
//        int cursorCount = cursor.getCount();
//        cursor.close();
//        db.close();
//
//        if (cursorCount > 0) {
//            return true;
//        }
//
//        return false;
//    }





    public List<FarmList> getAllBeneficiary() {
        // array of columns to fetch
        String[] columns = {
                BeneficiaryContract.BeneficiaryEntry._ID,
                BeneficiaryContract.BeneficiaryEntry.COLUMN_CHICKEN_SOLD,
                BeneficiaryContract.BeneficiaryEntry.COLUMN_CHICKS_SOLD,
                BeneficiaryContract.BeneficiaryEntry.COLUMN_EGGS_SOLD,
//                BeneficiaryContract.BeneficiaryEntry.COLUMN_BENEFICIARY_COUNTRY
        };
        // sorting orders
        String sortOrder =
                BeneficiaryContract.BeneficiaryEntry._ID + " ASC";
        List<FarmList> farmListList = new ArrayList<FarmList>();

        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.query(BeneficiaryContract.BeneficiaryEntry.TABLE_NAME, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                FarmList farmList = new FarmList();
//                farmList.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(BeneficiaryContract.BeneficiaryEntry._ID))));
                farmList.setId(cursor.getString(cursor.getColumnIndex(BeneficiaryContract.BeneficiaryEntry._ID)));
                farmList.setChickenSold(Integer.parseInt(cursor.getString(cursor.getColumnIndex(BeneficiaryContract.BeneficiaryEntry.COLUMN_CHICKEN_SOLD))));
                farmList.setChicksSold(Integer.parseInt(cursor.getString(cursor.getColumnIndex(BeneficiaryContract.BeneficiaryEntry.COLUMN_CHICKS_SOLD))));
                farmList.setEggsSold(Integer.parseInt(cursor.getString(cursor.getColumnIndex(BeneficiaryContract.BeneficiaryEntry.COLUMN_EGGS_SOLD))));
//                farmList.setEmail(cursor.getString(cursor.getColumnIndex(BeneficiaryContract.BeneficiaryEntry.COLUMN_BENEFICIARY_EMAIL)));
//                farmList.setAddress(cursor.getString(cursor.getColumnIndex(BeneficiaryContract.BeneficiaryEntry.COLUMN_BENEFICIARY_ADDRESS)));
//                farmList.setCountry(cursor.getString(cursor.getColumnIndex(BeneficiaryContract.BeneficiaryEntry.COLUMN_BENEFICIARY_COUNTRY)));
                // Adding user record to list
                farmListList.add(farmList);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return farmListList;
    }

}
