package com.example.apicall;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIClient {
    @GET("users")
    Call<List<PostModel>> getUsers();
}
