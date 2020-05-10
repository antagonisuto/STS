package com.example.soultosoul.CudiQ.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.soultosoul.MarfaQ.Entities.Blog;
import com.example.soultosoul.MarfaQ.Network.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    private MutableLiveData<List<Blog>> allBlog = new MutableLiveData<>();
    private NetworkService service;

    public MainRepository() {
        service = NetworkService.getInstance();
    }

    public MutableLiveData<List<Blog>> getAllBlog() {
        service.getJSONApi().getAllBlogs().enqueue(new Callback<List<Blog>>() {
            @Override
            public void onResponse(Call<List<Blog>> call, Response<List<Blog>> response) {
                if (response.isSuccessful()) {
                    List<Blog> blog = response.body();
                    allBlog.setValue(blog);
                }
            }

            @Override
            public void onFailure(Call<List<Blog>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return allBlog;
    }
}
