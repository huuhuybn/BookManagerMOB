package com.example.thanh.android_project_mob204.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.thanh.android_project_mob204.R;
import com.example.thanh.android_project_mob204.adapter.BookAdapter;
import com.example.thanh.android_project_mob204.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookFragment extends Fragment {
    private ListView lvBook;
    private List<Book> listBook;
    private BookAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        lvBook = view.findViewById(R.id.lvBook);
        createData();
        adapter = new BookAdapter(getContext(), R.layout.item_listview_book, listBook);
        lvBook.setAdapter(adapter);
        return view;
    }

    private void createData() {
        listBook = new ArrayList<>();
        listBook.add(new Book("Title 1", R.drawable.bia1, "Born là một bí ẩn trong văn học mạng, người ta chỉ biết đến cô qua khối lượng tác phẩm khá lớn đã được in thành sách."));
        listBook.add(new Book("Title 2", R.drawable.bia2, "Born là một bí ẩn trong văn học mạng, người ta chỉ biết đến cô qua khối lượng tác phẩm khá lớn đã được in thành sách."));
        listBook.add(new Book("Title 3", R.drawable.bia3, "Born là một bí ẩn trong văn học mạng, người ta chỉ biết đến cô qua khối lượng tác phẩm khá lớn đã được in thành sách."));
        listBook.add(new Book("Title 4", R.drawable.bia4, "Born là một bí ẩn trong văn học mạng, người ta chỉ biết đến cô qua khối lượng tác phẩm khá lớn đã được in thành sách."));
        listBook.add(new Book("Title 5", R.drawable.bia5, "Born là một bí ẩn trong văn học mạng, người ta chỉ biết đến cô qua khối lượng tác phẩm khá lớn đã được in thành sách."));
    }
}
