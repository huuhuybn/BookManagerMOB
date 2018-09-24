package com.example.thanh.android_project_mob204.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.thanh.android_project_mob204.R;

public class UserHolder extends RecyclerView.ViewHolder {


    public final TextView tvName;
    public final TextView tvPhone;



    public UserHolder(View convertView) {
        super(convertView);
        tvName = convertView.findViewById(R.id.tvName);
        tvPhone = convertView.findViewById(R.id.tvPhone);
    }


}
