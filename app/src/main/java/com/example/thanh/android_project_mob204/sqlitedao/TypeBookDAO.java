package com.example.thanh.android_project_mob204.sqlitedao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.thanh.android_project_mob204.Constant;
import com.example.thanh.android_project_mob204.database.DatabaseHelper;


import java.util.ArrayList;
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

    public long updateTypeBook(TypeBook typeBook) {

        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        //  Tao doi tuong de truyen du lieu la ContentValues
        ContentValues contentValues = new ContentValues();

        // Dua gia tri tuong ung tu User vao ContentValues
        contentValues.put(TB_COLUMN_ID, typeBook.id);

        contentValues.put(TB_COLUMN_NAME, typeBook.name);

        contentValues.put(TB_COLUMN_DESCRIPTION, typeBook.description);

        contentValues.put(TB_COLUMN_POSITION, typeBook.position);


        // updating row
        long result =  db.update(TABLE_TYPE_BOOK, contentValues, TB_COLUMN_ID + " = ?",
                new String[]{String.valueOf(typeBook.id)});


        return result;
    }


    public long deleteTypeBook(String typeBookID) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        long result = db.delete(TABLE_TYPE_BOOK, TB_COLUMN_ID + " = ?",
                new String[]{String.valueOf(typeBookID)});
        db.close();
        return result;
    }


    public List<TypeBook> getAllTypeBooks() {


        List<TypeBook> typeBooks = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        // viet cau lenh truy can toan bo danh sach user;
        String SELECT_ALL_TYPE_BOOKS = "SELECT * FROM " + TABLE_TYPE_BOOK;

        // cursor la doi tuong de chua ket qua truy van
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL_TYPE_BOOKS, null);

        if (cursor.moveToFirst()) {
            do {

                String typeId = cursor.getString(cursor.getColumnIndex(TB_COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(TB_COLUMN_NAME));
                String description = cursor.getString(cursor.getColumnIndex(TB_COLUMN_DESCRIPTION));
                String position = cursor.getString(cursor.getColumnIndex(TB_COLUMN_POSITION));

                TypeBook typeBook = new TypeBook();

                typeBook.id = typeId;
                typeBook.name = name;
                typeBook.description = description;
                typeBook.position = position;

                typeBooks.add(typeBook);


            } while (cursor.moveToNext());

        }

        return typeBooks;
    }

    public TypeBook getTypeBookByID(String id) {

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
