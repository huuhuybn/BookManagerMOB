package com.example.thanh.android_project_mob204.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thanh.android_project_mob204.R;
import com.example.thanh.android_project_mob204.adapter.AdapterTypeBook;
import com.example.thanh.android_project_mob204.database.DatabaseHelper;
import com.example.thanh.android_project_mob204.sqlitedao.TypeBook;
import com.example.thanh.android_project_mob204.sqlitedao.TypeBookDAO;

import java.util.List;
import java.util.Random;

public class LibraryFragment extends Fragment {


    private RecyclerView lvTypeBooks;

    private AdapterTypeBook adapterTypeBook;
    private List<TypeBook> typeBooks;

    private LinearLayoutManager linearLayoutManager;

    private DatabaseHelper databaseHelper;
    private TypeBookDAO typeBookDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        lvTypeBooks = view.findViewById(R.id.lvTypeBooks);
        databaseHelper = new DatabaseHelper(getActivity());
        typeBookDAO = new TypeBookDAO(databaseHelper);

        linearLayoutManager = new LinearLayoutManager(getActivity());

        typeBooks = typeBookDAO.getAllTypeBooks();

        for (int i = 0; i < 20; i++) {

            TypeBook typeBook = new TypeBook();
            typeBook.id = i + new Random().nextInt() + "";
            typeBook.name = "Android " + new Random().nextInt();
            typeBook.description = "Hello Moto";
            typeBook.position = i + "";
            typeBooks.add(typeBook);

        }

        Log.e("SIZE" , typeBooks.size() + "");

        adapterTypeBook = new AdapterTypeBook(getActivity(), typeBooks, typeBookDAO);

        lvTypeBooks.setLayoutManager(linearLayoutManager);

        lvTypeBooks.setAdapter(adapterTypeBook);


        return view;
    }


}
