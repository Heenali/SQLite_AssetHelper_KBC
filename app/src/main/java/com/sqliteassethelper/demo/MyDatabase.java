package com.sqliteassethelper.demo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteAssetHelper
{

    private static final String DATABASE_NAME = "KBC.db";
    private static final int DATABASE_VERSION = 1;
    private static final String ID="Id";
    private static final String t1="t1";
    private static final String t2="t2";
    private static final String t3="t3";
    private static final String t4="t4";
    private static final String t5="t5";
    private static final String t6="t6";
    private static final String t7="t7";
    private static final String t8="t8";
    private static final String POSES_TABLE="KBC";


    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public ArrayList<Poses> getPoses(){
        SQLiteDatabase db=getWritableDatabase();
        String[] columns={MyDatabase.ID,MyDatabase.t1,MyDatabase.t2,MyDatabase.t3,MyDatabase.t4,MyDatabase.t5,MyDatabase.t6,MyDatabase.t7,MyDatabase.t8};
//        String[] selectionArgs={categoryId+"",subjectId+"",yearId+""};
        Cursor cursor=db.query(MyDatabase.POSES_TABLE, columns, null, null, null, null, null,null);
//        Cursor cursor=db.query(MyDatabase.TABLE_NAME, columns, null,null, null, null, null);
        ArrayList<Poses> questionsArrayList=new ArrayList<>();

        while(cursor.moveToNext())
        {
            Poses questions=new Poses();
            questions.id=cursor.getInt(cursor.getColumnIndex(MyDatabase.ID));
            questions.t1=cursor.getString(cursor.getColumnIndex(MyDatabase.t1));
            questions.t2=cursor.getString(cursor.getColumnIndex(MyDatabase.t2));
            questions.t3=cursor.getString(cursor.getColumnIndex(MyDatabase.t3));
            questions.t4=cursor.getString(cursor.getColumnIndex(MyDatabase.t4));
            questions.t5=cursor.getString(cursor.getColumnIndex(MyDatabase.t5));
            questions.t6=cursor.getString(cursor.getColumnIndex(MyDatabase.t6));
            questions.t7=cursor.getString(cursor.getColumnIndex(MyDatabase.t7));
            questions.t8=cursor.getString(cursor.getColumnIndex(MyDatabase.t8));
            questionsArrayList.add(questions);

        }
        return questionsArrayList;
    }




}