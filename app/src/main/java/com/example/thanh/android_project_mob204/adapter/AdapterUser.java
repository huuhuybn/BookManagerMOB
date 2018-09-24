package com.example.thanh.android_project_mob204.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thanh.android_project_mob204.R;
import com.example.thanh.android_project_mob204.holder.UserHolder;
import com.example.thanh.android_project_mob204.model.User;

import java.util.List;

public class AdapterUser extends RecyclerView.Adapter<UserHolder> {

    private Context context;
    private List<User> userList;


    public AdapterUser(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }


    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {

        holder.tvName.setText(userList.get(position).getName());

        holder.tvPhone.setText(userList.get(position).getPhone());


    }

    @Override
    public int getItemCount() {
        if (userList == null) return 0;
        return userList.size();
    }
}
