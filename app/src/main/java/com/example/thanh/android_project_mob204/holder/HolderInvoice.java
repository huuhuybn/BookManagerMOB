package com.example.thanh.android_project_mob204.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thanh.android_project_mob204.R;

public class HolderInvoice extends RecyclerView.ViewHolder {
    public TextView tvInfo;
    public ImageView btnDelete;

    public HolderInvoice(View itemView) {
        super(itemView);

        tvInfo = itemView.findViewById(R.id.tvInfo);
        btnDelete = itemView.findViewById(R.id.btnDelete);

    }


}
