package com.example.thanh.android_project_mob204.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thanh.android_project_mob204.R;
import com.example.thanh.android_project_mob204.holder.HolderInvoice;
import com.example.thanh.android_project_mob204.model.Invoice;

import java.util.List;

public class AdapterInvoice extends RecyclerView.Adapter<HolderInvoice> {


    public Context context;
    public List<Invoice> invoices;


    public AdapterInvoice(Context context, List<Invoice> invoices) {
        this.context = context;
        this.invoices = invoices;
    }


    @NonNull
    @Override
    public HolderInvoice onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_invoice,
                parent, false);

        return new HolderInvoice(view);

    }

    @Override
    public void onBindViewHolder(@NonNull HolderInvoice holder, int position) {

        Invoice invoice = invoices.get(position);

        holder.tvInfo.setText(invoice.toString());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        if (invoices == null) return 0;
        return invoices.size();
    }
}
