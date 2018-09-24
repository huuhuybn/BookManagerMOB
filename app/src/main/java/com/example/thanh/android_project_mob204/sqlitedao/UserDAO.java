package com.example.thanh.android_project_mob204.sqlitedao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.thanh.android_project_mob204.Constant;
import com.example.thanh.android_project_mob204.database.DatabaseHelper;
import com.example.thanh.android_project_mob204.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO implements Constant {


    private DatabaseHelper databaseHelper;

    public UserDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void insertUser(User user) {

        // xin quyen ghi!!!
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        //  Tao doi tuong de truyen du lieu la ContentValues
        ContentValues contentValues = new ContentValues();

        // Dua gia tri tuong ung tu User vao ContentValues

        contentValues.put(COLUMN_USERNAME, user.getUsername());

        contentValues.put(COLUMN_PASSWORD, user.getPassword());

        contentValues.put(COLUMN_NAME, user.getName());

        contentValues.put(COLUMN_PHONE_NUMBER, user.getPhone());


        // Viet cau lenh insert vao DB

        long id = sqLiteDatabase.insert(TABLE_USER, null, contentValues);

        Log.e("insertUser", "ID = " + id);

        sqLiteDatabase.close();

    }


    public User getUser(String username) {
        User user = null;

        // xin quyen ghi!!!
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        // Tao cau lenh query voi Cursor
        Cursor cursor = sqLiteDatabase.query
                (TABLE_USER, new String[]{COLUMN_USERNAME, COLUMN_PASSWORD, COLUMN_NAME, COLUMN_PHONE_NUMBER},
                        COLUMN_USERNAME + "=?", new String[]{username},
                        null, null, null);

        // kiem tra xem cursor !=null va co chua gia tri
        if (cursor != null && cursor.moveToFirst()) {

            String user_name = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
            String password = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            String phone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE_NUMBER));
            user = new User(user_name, password, name, phone);


        }


        return user;
    }


    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        // viet cau lenh truy can toan bo danh sach user;
        String SELECT_ALL_USERS = "SELECT * FROM " + TABLE_USER;

        // cursor la doi tuong de chua ket qua truy van
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL_USERS, null);

        if (cursor.moveToFirst()) {
            do {


                String user_name = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
                String password = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String phone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE_NUMBER));
                User user = new User(user_name, password, name, phone);

                userList.add(user);


            } while (cursor.moveToNext());

        }


        return userList;

    }


    public void deleteUser(String username){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.delete(TABLE_USER, COLUMN_USERNAME + " = ?",
                new String[]{String.valueOf(username)});
        db.close();
    }


    public long updateUser(User user){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        //  Tao doi tuong de truyen du lieu la ContentValues
        ContentValues contentValues = new ContentValues();

        // Dua gia tri tuong ung tu User vao ContentValues

        contentValues.put(COLUMN_USERNAME, user.getUsername());

        contentValues.put(COLUMN_PASSWORD, user.getPassword());

        contentValues.put(COLUMN_NAME, user.getName());

        contentValues.put(COLUMN_PHONE_NUMBER, user.getPhone());

        // updating row
        return db.update(TABLE_USER, contentValues, COLUMN_USERNAME + " = ?",
                new String[]{String.valueOf(user.getUsername())});
    }


}
