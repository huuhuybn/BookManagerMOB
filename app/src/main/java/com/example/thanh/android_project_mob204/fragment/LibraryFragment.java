package com.example.thanh.android_project_mob204.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thanh.android_project_mob204.R;

public class LibraryFragment extends Fragment {


    private RecyclerView lvTypeBooks;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        lvTypeBooks = view.findViewById(R.id.lvTypeBooks);


        return view;
    }


}
