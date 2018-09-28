package com.example.thanh.android_project_mob204.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thanh.android_project_mob204.R;
import com.example.thanh.android_project_mob204.holder.HolderTypeBook;
import com.example.thanh.android_project_mob204.sqlitedao.TypeBook;
import com.example.thanh.android_project_mob204.sqlitedao.TypeBookDAO;

import java.util.List;

public class AdapterTypeBook extends RecyclerView.Adapter<HolderTypeBook> {


    private Context context;
    private List<TypeBook> typeBooks;
    private TypeBookDAO typeBookDAO;

    public AdapterTypeBook(Context context, List<TypeBook> typeBooks, TypeBookDAO typeBookDAO) {
        this.context = context;
        this.typeBooks = typeBooks;
        this.typeBookDAO = typeBookDAO;
    }


    @NonNull
    @Override
    public HolderTypeBook onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_type_book,
                parent, false);
        return new HolderTypeBook(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderTypeBook holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
