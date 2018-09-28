package com.example.thanh.android_project_mob204.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    public void onBindViewHolder(@NonNull HolderTypeBook holder, final int position) {
        final TypeBook typeBook = typeBooks.get(position);
        holder.tvID.setText(typeBook.id);
        holder.tvName.setText(typeBook.name);


        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long result = typeBookDAO.deleteTypeBook(typeBook.id);
                if (result < 0) {
                    Toast.makeText(context,"Co loi xay ra!!!",Toast.LENGTH_SHORT).show();
                } else {
                    // xoa du lieu tuong ung sau khi xoa trong DB
                    typeBooks.remove(position);

                    // f5 lai listview
                    notifyDataSetChanged();

                }

            }
        });
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_update_type_book);
                 final EditText edtTypeName;
                 final EditText edtDescription;
                 final EditText edtPosition;
                 Button btnUpdate;
                 Button btnCancel;

                edtTypeName = dialog.findViewById(R.id.edtTypeName);
                edtDescription = dialog.findViewById(R.id.edtDescription);
                edtPosition = dialog.findViewById(R.id.edtPosition);
                btnUpdate = dialog.findViewById(R.id.btnUpdate);
                btnCancel = dialog.findViewById(R.id.btnCancel);

                edtTypeName.setText(typeBook.name);
                edtDescription.setText(typeBook.description);
                edtPosition.setText(typeBook.position);


                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        TypeBook typeBook1 = new TypeBook();
                        typeBook1.id = typeBook.id;

                        String name = edtTypeName.getText().toString().trim();
                        String des = edtDescription.getText().toString().trim();
                        String pos = edtPosition.getText().toString().trim();

                        typeBook1.name = name;
                        typeBook1.description = des;
                        typeBook1.position = pos;

                        long result = typeBookDAO.updateTypeBook(typeBook1);
                        if (result< 0){
                            Toast.makeText(context,"Co loi xay ra!!!",Toast.LENGTH_SHORT).show();
                        }else {

                            typeBooks.get(position).name = name;
                            typeBooks.get(position).description = des;
                            typeBooks.get(position).position = pos;

                            // f5 listview
                            notifyDataSetChanged();

                            dialog.dismiss();
                        }


                    }
                });

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });



                dialog.show();



            }
        });

    }

    @Override
    public int getItemCount() {
        return typeBooks.size();
    }
}
