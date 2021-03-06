package com.example.thanh.android_project_mob204.sqlitedao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thanh.android_project_mob204.Constant;
import com.example.thanh.android_project_mob204.database.DatabaseHelper;
import com.example.thanh.android_project_mob204.model.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO implements Constant {

    private DatabaseHelper databaseHelper;

    public InvoiceDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public long insertInvoice(Invoice invoice) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(I_COLUMN_ID, invoice.id);
        contentValues.put(I_COLUMN_DATE, invoice.date);

        long result = sqLiteDatabase.insert(INVOICE_TABLE, null, contentValues);

        sqLiteDatabase.close();
        return result;
    }

    public long updateInvoice(Invoice invoice
    ) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(I_COLUMN_DATE, invoice.date);

        long result = sqLiteDatabase.update(INVOICE_TABLE, contentValues,
                TB_COLUMN_ID + "=?",
                new String[]{invoice.id});

        sqLiteDatabase.close();

        return result;

    }

    public long deleteInvoice(String invoiceID) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        long result = sqLiteDatabase.delete(INVOICE_TABLE, TB_COLUMN_ID + "=?",
                new String[]{invoiceID});

        sqLiteDatabase.close();

        return result;
    }

    public List<Invoice> getAllInvoices() {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        List<Invoice> invoices = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + INVOICE_TABLE,
                null);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {

                String id = cursor.getString(cursor.getColumnIndex(I_COLUMN_ID));
                long date = cursor.getLong(cursor.getColumnIndex(I_COLUMN_DATE));

                Invoice invoice = new Invoice(id, date);

                invoices.add(invoice);

            } while (cursor.moveToNext());

        }

        sqLiteDatabase.close();

        return invoices;
    }

    public Invoice getInvoiceByID(String invoiceID) {

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        Invoice invoice = null;

        Cursor cursor = sqLiteDatabase.query(INVOICE_TABLE,
                new String[]{I_COLUMN_ID, I_COLUMN_DATE}, TB_COLUMN_ID + "=?",
                new String[]{invoiceID}, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            String id = cursor.getString(cursor.getColumnIndex(I_COLUMN_ID));
            long date = cursor.getLong(cursor.getColumnIndex(I_COLUMN_DATE));
            invoice = new Invoice(id, date);

        }

        sqLiteDatabase.close();

        return invoice;
    }


}
