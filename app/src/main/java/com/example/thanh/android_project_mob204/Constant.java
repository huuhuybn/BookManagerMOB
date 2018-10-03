package com.example.thanh.android_project_mob204;

public interface Constant {


    // result Code


    int ADD_USER = 8888;

    // User Table

    // ----------------------------------------
    String TABLE_USER = "USER";

    String COLUMN_USERNAME = "Username";

    String COLUMN_PASSWORD = "Password";

    String COLUMN_NAME = "Name";

    String COLUMN_PHONE_NUMBER = "Phone_number";


    String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + " (" +

            COLUMN_USERNAME + " VARCHAR PRIMARY KEY," +
            COLUMN_PASSWORD + " VARCHAR," +
            COLUMN_NAME + " VARCHAR," +
            COLUMN_PHONE_NUMBER + " VARCHAR"

            + ")";

    // ----------------------------------------
    // TYPE  BOOK TABLE
    // CREATE TABLE TypeBook (MaTheLoai CHAR(5) PRIMARY KEY NOT NULL,
    // TypeName NVARCHAR(50) NOT NULL,
    //  Description NVARCHAR(255),
    // Position  INT
    // )


    String TABLE_TYPE_BOOK = "TypeBook";

    String TB_COLUMN_ID = "MaTheLoai";
    String TB_COLUMN_NAME = "TypeName";
    String TB_COLUMN_DESCRIPTION = "Description";
    String TB_COLUMN_POSITION = "Position";

    String CREATE_TABLE_TYPE_BOOK = "CREATE TABLE " + TABLE_TYPE_BOOK + "(" +
            "" + TB_COLUMN_ID + " CHAR(5) PRIMARY KEY NOT NULL," +
            "" + TB_COLUMN_NAME + " NVARCHAR(50) NOT NULL," +
            "" + TB_COLUMN_DESCRIPTION + " NVARCHAR(255)," +
            "" + TB_COLUMN_POSITION + " INT" +
            ")";


    // TABLE INVOICE

    // CREATE TABLE Invoice (MaHoaDon NCHAR(7) PRIMARY KEY NOT NULL, NgayMua LONG NOT NULL)

    String INVOICE_TABLE = "Invoice";

    String I_COLUMN_ID = "MaHoaDon";
    String I_COLUMN_DATE = "NgayMua";

    String CREATE_INVOICE_TABLE = "CREATE TABLE " + INVOICE_TABLE + "(" +
            "" + I_COLUMN_ID + " NCHAR(7) PRIMARY KEY NOT NULL," +
            "" + I_COLUMN_DATE + " LONG NOT NULL" +
            ")";



}
