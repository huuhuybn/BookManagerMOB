package com.example.thanh.android_project_mob204.model;

import java.util.Date;

public class Invoice {

    public String id;
    public long date;

    public Invoice(String id, long date) {
        this.id = id;
        this.date = date;
    }

    @Override
    public String toString() {

        String dateConvert = new Date(date).toString();
        return id + "\n" + dateConvert;
    }
}
