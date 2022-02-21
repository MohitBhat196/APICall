package com.example.apicall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.apicall.adapter.PostAdapter;
import com.example.apicall.model.PostModel;
import com.example.apicall.viewmodel.PostListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<PostModel>postModelList;
    private PostAdapter adapter;
    private PostListViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PostAdapter(this, postModelList);
        recyclerView.setAdapter(adapter);


       viewModel = ViewModelProviders.of(this).get(PostListViewModel.class);
       viewModel.getUsersViewObserver().observe(this, new Observer<List<PostModel>>() {
           @Override
           public void onChanged(List<PostModel> postModels) {
               if(postModels != null ){
                   postModelList = postModels;
                   adapter.setUserList(postModels);

               }
           }

       });
        viewModel.makeApiCall();

    }

}