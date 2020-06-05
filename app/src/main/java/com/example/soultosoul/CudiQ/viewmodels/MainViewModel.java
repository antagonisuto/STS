package com.example.soultosoul.CudiQ.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.soultosoul.CudiQ.repository.MainRepository;
import com.example.soultosoul.MarfaQ.Entities.Article;
import com.example.soultosoul.MarfaQ.Entities.Blog;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainViewModel extends ViewModel {
    private MainRepository repository = new MainRepository();
    public MutableLiveData<String> marfaString = new MutableLiveData<>();
    public MutableLiveData<Integer> reason = new MutableLiveData<>();
    public MutableLiveData<Integer> category = new MutableLiveData<>();
    public MutableLiveData<Integer> adultReason = new MutableLiveData<>();

    public MutableLiveData<Integer> getReason() {
        return reason;
    }
    public MutableLiveData<Integer> getCategory() {
        return category;
    }

    public MutableLiveData<Integer> getAdultReason() {
        return adultReason;
    }

    public MainViewModel() {
        marfaString.setValue("Marfa");
    }

    public MutableLiveData<List<Blog>> getAllBlogData() {

        return repository.getAllBlog();
    }

    public MutableLiveData<List<Article>> getAllArticleData(){

        return repository.getAllArticle();
    }

    public MutableLiveData<Article> getArticleById(long id) {
        return repository.getArticleById(id);
    }

    public MutableLiveData<String> getMarfaString() {

        return marfaString;
    }

    public MutableLiveData<List<Article>> getArticleByCatProb(int catId, int probId){
        return repository.getArticleByCatProb(catId, probId);
    }

    public MutableLiveData<List<Article>> getArticleByCat(int catId){
        return repository.getArticleByCat(catId);
    }

    public MutableLiveData<List<Article>> getArticleKid(){
        return repository.getArticleKid();
    }

}