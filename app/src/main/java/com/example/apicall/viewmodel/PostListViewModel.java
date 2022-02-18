package com.example.apicall.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apicall.model.PostModel;
import com.example.apicall.network.APIClient;
import com.example.apicall.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostListViewModel extends ViewModel {

    private MutableLiveData<List<PostModel>>usersView;

    public PostListViewModel(){

        usersView = new MutableLiveData<>();
    }

    public MutableLiveData<List<PostModel>>getUsersViewObserver(){


        return usersView;
    }

    public void makeApiCall(){
        APIClient apiClient = RetrofitInstance.getRetroClient().create(APIClient.class);
        Call<List<PostModel>> call = apiClient.getUsers();
        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                usersView.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                usersView.postValue(null);
            }
        });
    }
}
