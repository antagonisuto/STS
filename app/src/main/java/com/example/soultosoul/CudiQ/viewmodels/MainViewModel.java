package com.example.soultosoul.CudiQ.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.soultosoul.CudiQ.repository.MainRepository;
import com.example.soultosoul.MarfaQ.Entities.Blog;

import java.util.List;

public class MainViewModel extends ViewModel {
    private MainRepository repository = new MainRepository();
    public MutableLiveData<String> marfaString = new MutableLiveData<>();

    public MainViewModel() {
        marfaString.setValue("Marfa");
    }

    public MutableLiveData<List<Blog>> getAllBlogData() {
        return repository.getAllBlog();
    }

    public MutableLiveData<String> getMarfaString() {
        return marfaString;
    }
}
