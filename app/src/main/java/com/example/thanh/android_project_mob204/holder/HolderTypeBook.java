package com.example.thanh.android_project_mob204.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thanh.android_project_mob204.R;

public class HolderTypeBook extends RecyclerView.ViewHolder {


    public TextView tvID;
    public TextView tvName;
    public Button btnEdit;
    public Button btnDelete;

    public HolderTypeBook(View itemView) {
        super(itemView);

        tvID = itemView.findViewById(R.id.tvID);
        tvName = itemView.findViewById(R.id.tvName);
        btnEdit = itemView.findViewById(R.id.btnEdit);
        btnDelete = itemView.findViewById(R.id.btnDelete);

    }
}
