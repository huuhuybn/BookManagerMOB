package com.example.thanh.android_project_mob204.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.thanh.android_project_mob204.R;
import com.example.thanh.android_project_mob204.adapter.AdapterInvoice;
import com.example.thanh.android_project_mob204.database.DatabaseHelper;
import com.example.thanh.android_project_mob204.model.Invoice;
import com.example.thanh.android_project_mob204.sqlitedao.InvoiceDAO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class InvoiceFragment extends Fragment {


    private RecyclerView lvListInvoice;
    private AdapterInvoice adapterInvoice;
    private LinearLayoutManager linearLayoutManager;
    private List<Invoice> invoices;


    private InvoiceDAO invoiceDAO;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_invoice, container, false);

        invoiceDAO = new InvoiceDAO(new DatabaseHelper(getActivity()));
        lvListInvoice = view.findViewById(R.id.lvListInvoice);

        invoices = invoiceDAO.getAllInvoices();


        for (int i = 0; i < 20; i++) {

            Invoice invoice = new Invoice(new Random().nextInt(1000) + "",
                    System.currentTimeMillis());
            invoices.add(invoice);

        }

        linearLayoutManager = new LinearLayoutManager(getActivity());

        adapterInvoice = new AdapterInvoice(getActivity(), invoices);

        lvListInvoice.setAdapter(adapterInvoice);
        lvListInvoice.setLayoutManager(linearLayoutManager);


        view.findViewById(R.id.btnAddInvoice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialogShowAddInvoice = new Dialog(getActivity());
                dialogShowAddInvoice.setTitle(getString(R.string.title_add_invoice));
                dialogShowAddInvoice.setContentView(R.layout.dialog_add_invoice);

                EditText edtInvoiceID;
                final TextView tvDatePicker;
                Button btnOpenDatePicker;

                edtInvoiceID = dialogShowAddInvoice.findViewById(R.id.edtInvoiceID);
                tvDatePicker = dialogShowAddInvoice.findViewById(R.id.tvDatePicker);
                btnOpenDatePicker = dialogShowAddInvoice.findViewById(R.id.btnOpenDatePicker);

                btnOpenDatePicker.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showDatePicker(tvDatePicker);
                    }
                });


                dialogShowAddInvoice.show();


            }
        });

        return view;
    }


    private void showDatePicker(final TextView tvDatePicker) {

        // lay ngay thang hien tai

        Calendar currentDate = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                long datePicked = 0;
                Calendar calendar = Calendar.getInstance();
                calendar.set(i, i1, i2);
                datePicked = calendar.getTimeInMillis();
                String datePicked_ = new Date(datePicked).toString();
                tvDatePicker.setText(datePicked_);


            }
        }, currentDate.get(Calendar.YEAR)
                , currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();

    }
}
