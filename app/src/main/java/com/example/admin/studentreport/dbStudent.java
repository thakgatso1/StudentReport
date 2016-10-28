package com.example.admin.studentreport;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016-10-12.
 */
public class dbStudent extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "databaseStudents";
    public static final String TABLE_NAME = "tblStudents";
    public static final String COLUMN1 = "studID";
    public static final String COLUMN2 = "studName";
    public static final String COLUMN3 = "studSurname";
    public static final String COLUMN4 = "subjectName";
    public static final String COLUMN5 = "mark1";
    public static final String COLUMN6 = "mark2";
    public static final String COLUMN7 = "mark3";


    public dbStudent(Context context) {
        super(context, DATABASE_NAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( " + COLUMN1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN2 + " TEXT, " + COLUMN3 + " TEXT, " + COLUMN4 + " TEXT, " + COLUMN5 + " INTEGER, " + COLUMN6 + " INTEGER, " + COLUMN7 + " INTEGER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean add(Student stud) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN2, stud.getStudName());
        contentValues.put(COLUMN3, stud.getStudSurname());
        contentValues.put(COLUMN4, stud.getSubjectName());
        contentValues.put(COLUMN5, stud.getMark1());
        contentValues.put(COLUMN6, stud.getMark2());
        contentValues.put(COLUMN7, stud.getMark3());

        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == 1) {
            return false;
        } else {
            return true;
        }


    }

    public Integer delete(Student std){
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME,COLUMN1+" =?" , new String[]{String.valueOf(std.getStudId())});
    }


    public boolean update(Student stud) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN1, stud.getStudId());
        contentValues.put(COLUMN2, stud.getStudName());
        contentValues.put(COLUMN3, stud.getStudSurname());
        contentValues.put(COLUMN4, stud.getSubjectName());
        contentValues.put(COLUMN5, stud.getMark1());
        contentValues.put(COLUMN6, stud.getMark2());
        contentValues.put(COLUMN7, stud.getMark3());

        db.update(TABLE_NAME, contentValues, "studID = ?", new String[]{String.valueOf(stud.getStudId())});

        return true;
    }

    public List<Student> getAllLearner() {

        List<Student> studList = new ArrayList<Student>();

        //Select all querry

        String selectQry = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQry, null);

        //looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                Student stud;
                stud = new Student(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)));

                studList.add(stud);

            } while (cursor.moveToNext());
        }

        //return Learner list
        return studList;

    }

    public Student getStud(String studName) {

        Cursor cursor;
        Student stud;
        SQLiteDatabase db = this.getReadableDatabase();

        //Select all querry
        if(!db.isOpen()){
            System.out.println("Database connection closed");
        }
        cursor = db.query(TABLE_NAME, null, COLUMN2 + "=?", new String[]{studName}, null, null, null);

        if (cursor != null) {
            if(cursor.getCount() > 0)
                cursor.moveToFirst();
            else
                return null;
        } else{
            System.out.println("Cursor is null");
            return null;
        }
        System.out.println(cursor.getCount() + " Number of Rows");

        //looping through all rows and adding to list

        stud = new Student(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)));

        return stud;
    }
}

