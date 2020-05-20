package com.example.spacestationv2.Model;


import com.example.spacestationv2.ViewModel.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("posts")
    Call<List<Post>> getPosts();
}