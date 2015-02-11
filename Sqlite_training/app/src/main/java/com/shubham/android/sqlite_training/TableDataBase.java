package com.shubham.android.sqlite_training;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class TableDataBase extends SQLiteOpenHelper{

       // public static abstract class FeedEntry implements BaseColumns {
        public static final String DATABASE_NAME = "ggitstimetable.db";
        public static final String COLUMN_NAME_DAY_NUMBER = "dayno";
        public static final String COLUMN_NAME_DAY = "day";
        public static final String COLUMN_NAME_1 = "c1";
        public static final String COLUMN_NAME_2 = "c2";
        public static final String COLUMN_NAME_3 = "c3";
        public static final String COLUMN_NAME_4 = "c4";
        //public static final String COLUMN_NAME_BREAK = "cbreak";
        public static final String COLUMN_NAME_5 = "c5";
        public static final String COLUMN_NAME_6 = "c6";
        public static final String COLUMN_NAME_7 = "c7";
   // }



    public TableDataBase(Context context) {
        //super(context,FeedEntry.DATABASE_NAME,null,1);
        super(context,DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    public void onCreate(SQLiteDatabase db , String TABLE_NAME) {
        db.execSQL( "create table " + TABLE_NAME + " ( " + COLUMN_NAME_DAY_NUMBER + " integer , " +
        COLUMN_NAME_DAY + " text , " + COLUMN_NAME_1 + " text , " + COLUMN_NAME_2 + " text , " +
        COLUMN_NAME_3 + " text , " + COLUMN_NAME_4 + " text , "  + COLUMN_NAME_5 + " text , "  +
        COLUMN_NAME_6 + " text , " + COLUMN_NAME_7 + " text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + );
        onCreate(db);
    }

    public void insertValues(String TABLE_NAME , int dayNum , String dayName , String p1 , String p2
            , String p3 , String p4  , String p5  , String p6  , String p7 ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME_DAY_NUMBER , dayNum);
        contentValues.put(COLUMN_NAME_DAY , dayName);
        contentValues.put(COLUMN_NAME_1 , p1);
        contentValues.put(COLUMN_NAME_2 , p2);
        contentValues.put(COLUMN_NAME_3 , p3);
        contentValues.put(COLUMN_NAME_4 , p4);
        contentValues.put(COLUMN_NAME_5 , p5);
        contentValues.put(COLUMN_NAME_6 , p6);
        contentValues.put(COLUMN_NAME_7 , p7);

        db.insert(TABLE_NAME,null,contentValues);
    }

    public Cursor getData(String TABLE_NAME , int dayNum) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(" select * from " + TABLE_NAME + " where " + COLUMN_NAME_DAY_NUMBER
                + "=" + dayNum,null);
        return res;
    }


}
