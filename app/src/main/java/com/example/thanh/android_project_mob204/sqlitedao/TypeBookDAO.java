package com.example.thanh.android_project_mob204.sqlitedao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.thanh.android_project_mob204.Constant;
import com.example.thanh.android_project_mob204.database.DatabaseHelper;
import com.example.thanh.android_project_mob204.model.User;

import java.util.List;

public class TypeBookDAO implements Constant {

    private DatabaseHelper databaseHelper;


    public TypeBookDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;

    }


    public long insertTypeBook(TypeBook typeBook) {

        // xin quyen ghi!!!
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        //  Tao doi tuong de truyen du lieu la ContentValues
        ContentValues contentValues = new ContentValues();

        // Dua gia tri tuong ung tu User vao ContentValues

        contentValues.put(TB_COLUMN_ID, typeBook.id);

        contentValues.put(TB_COLUMN_NAME, typeBook.name);

        contentValues.put(TB_COLUMN_DESCRIPTION, typeBook.description);

        contentValues.put(TB_COLUMN_POSITION, typeBook.position);


        // Viet cau lenh insert vao DB

        long result = sqLiteDatabase.insert(TABLE_TYPE_BOOK, null, contentValues);

        Log.e("insertTypeBook", "ID = " + typeBook.id);

        sqLiteDatabase.close();

        return result;
    }

    public long updateTypeBook() {


        return -1;
    }


    public long deleteTypeBook() {


        return -1;
    }


    public List<TypeBook> getAllTypeBooks() {


        return null;
    }

    public TypeBook getTypeBookByID(String id){

        TypeBook typeBook = null;

        // xin quyen ghi!!!
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        // Tao cau lenh query voi Cursor
        Cursor cursor = sqLiteDatabase.query
                (TABLE_TYPE_BOOK, new String[]{TB_COLUMN_ID, TB_COLUMN_NAME, TB_COLUMN_DESCRIPTION, TB_COLUMN_POSITION},
                        TB_COLUMN_ID + "=?", new String[]{id},
                        null, null, null);

        // kiem tra xem cursor !=null va co chua gia tri
        if (cursor != null && cursor.moveToFirst()) {

            String typeId = cursor.getString(cursor.getColumnIndex(TB_COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(TB_COLUMN_NAME));
            String description = cursor.getString(cursor.getColumnIndex(TB_COLUMN_DESCRIPTION));
            String position = cursor.getString(cursor.getColumnIndex(TB_COLUMN_POSITION));

            typeBook = new TypeBook();

            typeBook.id = typeId;
            typeBook.name = name;
            typeBook.description = description;
            typeBook.position = position;

        }


        return typeBook;

    }


}
