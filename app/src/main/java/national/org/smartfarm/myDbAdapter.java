package national.org.smartfarm;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import national.org.smartfarm.model.FarmList;
import national.org.smartfarm.sql.BeneficiaryContract;

public class myDbAdapter {
    myDbHelper myhelper;
    private String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    ListItem listItem;

    String chicknSold;
    public myDbAdapter(Context context){
        myhelper = new myDbHelper(context);
    }

    public void insertData(/*int chickenSold, int eggsSold, int chicksSold*/FarmList farmList){
        SQLiteDatabase dbb =  myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.UID, date.toString());
        contentValues.put(myDbHelper.CHICKEN_SOLD, farmList.getChickenSold());
        contentValues.put(myDbHelper.CHICKS_SOLD, farmList.getChicksSold());
        contentValues.put(myDbHelper.EGGS_SOLD, farmList.getEggsSold());
        /*Long id = */dbb.insert(myDbHelper.TABLE_NAME, null, contentValues);
//        if(id == -1)
//            return false;
//        else
//            return true;

    }

    public  boolean insertData2(int chickendeaths, int feeds, int vaccines){
        SQLiteDatabase dbb =  myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.UID, date.toString());
        contentValues.put(myDbHelper.CHICKEN_DEATHS, chickendeaths);
        contentValues.put(myDbHelper.VACCINES, vaccines);
        contentValues.put(myDbHelper.FEEDS, feeds);
        Long id = dbb.insert(myDbHelper.TABLE_NAME2, null, contentValues);
        if(id == -1)
            return false;
        else
            return true;

    }

    public  boolean insertData3(int eggsCollected, int eggsHatched, int chickenVaccinated){
        SQLiteDatabase dbb =  myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.UID, date.toString());
        contentValues.put(myDbHelper.EGGS_COLLECTED, eggsCollected);
        contentValues.put(myDbHelper.EGGS_COLLECTED, eggsHatched);
        contentValues.put(myDbHelper.CHICKEN_VACCINATED, chickenVaccinated);
        Long id = dbb.insert(myDbHelper.TABLE_NAME3, null, contentValues);
        if(id == -1)
            return false;
        else
            return true;

    }



    public String getID(){
        SQLiteDatabase dbb =  myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID};
        Cursor res = dbb.query(myDbHelper.TABLE_NAME,columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();

        while (res.moveToNext()){
            String cid = res.getString(res.getColumnIndex(myDbHelper.UID));

            buffer.append(cid);


        }


        return buffer.toString();
    }

    public List<FarmList>getData(){
        SQLiteDatabase dbb =  myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID, myDbHelper.CHICKEN_SOLD, myDbHelper.CHICKS_SOLD, myDbHelper.EGGS_SOLD};

        String sortOrder =
                BeneficiaryContract.BeneficiaryEntry._ID + " ASC";

        List<FarmList> myList = new ArrayList<FarmList>();

//        SQLiteDatabase db = myhelper.getReadableDatabase();

        Cursor res = dbb.query(myDbHelper.TABLE_NAME,columns, null, null, null, null, sortOrder);


        StringBuffer buffer = new StringBuffer();

        while (res.moveToFirst()){
            do {
                FarmList listitem = new FarmList();

                listitem.setId(res.getString(res.getColumnIndex(myDbHelper.UID)));
                listitem.setChickenSold(res.getInt(res.getColumnIndex(myDbHelper.CHICKEN_SOLD)));
                listitem.setChicksSold(res.getInt(res.getColumnIndex(myDbHelper.CHICKS_SOLD)));
                listitem.setEggsSold(res.getInt(res.getColumnIndex(myDbHelper.EGGS_SOLD)));

                myList.add(listitem);
//                buffer.append(/*cid+" "+*/chickensold + "                   | " + chicksSold + "                   | " + eggsSold + "\n");

//            String ar[] = new String[4];
//            ar[0] = buffer.append(chickensold).toString();
//            ar[1] = buffer.append(chicksSold).toString();
//            ar[2] = buffer.append(eggsSold).toString();
            }while (res.moveToNext());
            res.close();
            dbb.close();
        }

//        chicknSold = (buffer.append(res.getInt(res.getColumnIndex(myDbHelper.CHICKEN_SOLD)))).toString();
//        listItem.setChicknSold(chicknSold);
//        String ar = new String();
//            int trial = res.getInt(res.getColumnIndex(myDbHelper.CHICKEN_SOLD));
//        buffer.append(trial);
//        ar = buffer.toString();
//            ar[1] = buffer.append(res.getInt(res.getColumnIndex(myDbHelper.CHICKS_SOLD))).toString();
//            ar[2] = buffer.append(res.getInt(res.getColumnIndex(myDbHelper.EGGS_SOLD))).toString();

//        return buffer.toString();
        return myList;
    }

    public String getExp(){
        SQLiteDatabase dbb =  myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID, myDbHelper.CHICKEN_DEATHS, myDbHelper.VACCINES, myDbHelper.FEEDS};
        Cursor res = dbb.query(myDbHelper.TABLE_NAME2,columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer1 = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        StringBuffer buffer3 = new StringBuffer();
        while (res.moveToNext()){
            String cid = res.getString(res.getColumnIndex(myDbHelper.UID));
            int chickensold = res.getInt(res.getColumnIndex(myDbHelper.CHICKEN_DEATHS));
            int chicksSold = res.getInt(res.getColumnIndex(myDbHelper.VACCINES));
            int eggsSold = res.getInt(res.getColumnIndex(myDbHelper.FEEDS));

            buffer.append(/*cid+" "+*/chickensold+"                   | "+chicksSold+"                   | "+eggsSold+"\n");

//            String ar[] = new String[4];
//            ar[0] = buffer.append(chickensold).toString();
//            ar[1] = buffer.append(chicksSold).toString();
//            ar[2] = buffer.append(eggsSold).toString();

        }

//        chicknSold = (buffer.append(res.getInt(res.getColumnIndex(myDbHelper.CHICKEN_SOLD)))).toString();
//        listItem.setChicknSold(chicknSold);
//        String ar = new String();
//            int trial = res.getInt(res.getColumnIndex(myDbHelper.CHICKEN_SOLD));
//        buffer.append(trial);
//        ar = buffer.toString();
//            ar[1] = buffer.append(res.getInt(res.getColumnIndex(myDbHelper.CHICKS_SOLD))).toString();
//            ar[2] = buffer.append(res.getInt(res.getColumnIndex(myDbHelper.EGGS_SOLD))).toString();

        return buffer.toString();
    }

    public String getInc(){
        SQLiteDatabase dbb =  myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID, myDbHelper.EGGS_COLLECTED, myDbHelper.EGGS_HATCHED, myDbHelper.CHICKEN_VACCINATED};
        Cursor res = dbb.query(myDbHelper.TABLE_NAME3,columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer1 = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        StringBuffer buffer3 = new StringBuffer();
        while (res.moveToNext()){
            String cid = res.getString(res.getColumnIndex(myDbHelper.UID));
            int chickensold = res.getInt(res.getColumnIndex(myDbHelper.EGGS_COLLECTED));
            int chicksSold = res.getInt(res.getColumnIndex(myDbHelper.EGGS_HATCHED));
            int eggsSold = res.getInt(res.getColumnIndex(myDbHelper.CHICKEN_VACCINATED));

            buffer.append(/*cid+" "+*/chickensold+"                   | "+chicksSold+"                   | "+eggsSold+"\n");

//            String ar[] = new String[4];
//            ar[0] = buffer.append(chickensold).toString();
//            ar[1] = buffer.append(chicksSold).toString();
//            ar[2] = buffer.append(eggsSold).toString();

        }

        return buffer.toString();
    }

    public List<ListItem> getAllItems(){
        String[] columns = {
                myhelper.UID,
                myhelper.EGGS_SOLD,
                myhelper.CHICKEN_SOLD,
                myhelper.CHICKS_SOLD
        };

        String sortOrder = myhelper.UID + " ACS";
        List<ListItem> ItemsList = new ArrayList<>();

        SQLiteDatabase db = myhelper.getReadableDatabase();

        Cursor cursor = db.query(myhelper.UID,
                columns,
                null,
                null,
                null,
                null,
                sortOrder);

        if(cursor.moveToFirst()){ do {
            ListItem listItem = new ListItem();

            listItem.setID(cursor.getString(cursor.getColumnIndex(myDbHelper.UID)));
            listItem.setChickenSold(cursor.getString(cursor.getColumnIndex(myDbHelper.CHICKEN_SOLD)));
            listItem.setChicksSold(cursor.getString(cursor.getColumnIndex(myDbHelper.CHICKS_SOLD)));
            listItem.setEggsSold(cursor.getString(cursor.getColumnIndex(myDbHelper.EGGS_SOLD)));

            ItemsList.add(listItem);
            }while(cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return ItemsList;
    }




    static class myDbHelper extends SQLiteOpenHelper{

        private static final String DATABASE_NAME = "FarmRecords";
        private static final String TABLE_NAME = "Income";
        private static final String TABLE_NAME2 = "Expenses";
        private static final String TABLE_NAME3 = "DailyRecords";
        private static final String UID = "_id";
        private static final String EGGS_SOLD="eggs_sold";
        private static final String CHICKEN_SOLD="chicken_sold";
        private static final String CHICKS_SOLD="chicks_sold";
        private static  final String CHICKEN_DEATHS ="chicken_deaths";
        private static  final String VACCINES = "vaccines";
        private static  final String FEEDS ="feeds";
        private static  final String EGGS_COLLECTED = "eggs_collected";
        private static  final String EGGS_HATCHED = "eggs_hatched";
        private static  final String CHICKEN_VACCINATED ="chicken_vaccinated";
        private static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME+ "("+UID+" TEXT KEY ,"+EGGS_SOLD+" INT (3), "+CHICKEN_SOLD+" INT (3), "+CHICKS_SOLD+" INT (3));";
        private static final String CREATE_TABLE2 = "CREATE TABLE "+ TABLE_NAME2+ "("+UID+" TEXT KEY ,"+CHICKEN_DEATHS+" INT (3), "+VACCINES+" INT (3), "+FEEDS+" INT (3));";
        private static final String CREATE_TABLE3 = "CREATE TABLE "+ TABLE_NAME3+ "("+UID+" TEXT KEY ,"+EGGS_COLLECTED+" INT (3), "+EGGS_HATCHED+" INT (3), "+CHICKEN_VACCINATED+" INT (3));";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
        private static final int DATABASE_Version = 1;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context = context;
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
            db.execSQL(CREATE_TABLE2);
            db.execSQL(CREATE_TABLE3);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
    }
}
