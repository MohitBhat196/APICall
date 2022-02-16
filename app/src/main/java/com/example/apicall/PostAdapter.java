package com.example.apicall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    List<PostModel> userList;
    Context context;

    public PostAdapter(Context context, List<PostModel>users){
        this.context = context;
        userList = users;

    }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items, parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        PostModel postModel = userList.get(position);
        holder.login.setText("Login : " + postModel.getLogin());
        holder.id.setText("ID : " + postModel.getId());
        holder.url.setText("Url : "+ postModel.getUrl());
        holder.repos_url.setText("Repos Url : " + postModel.getRepos_url());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        TextView login, id, url, repos_url;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            login = itemView.findViewById(R.id.login);
            id = itemView.findViewById(R.id.userId);
            url = itemView.findViewById(R.id.url);
            repos_url = itemView.findViewById(R.id.reposUrl);

        }
    }
}
