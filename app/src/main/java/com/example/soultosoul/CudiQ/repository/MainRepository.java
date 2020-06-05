package com.example.soultosoul.CudiQ.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.soultosoul.MarfaQ.Entities.Article;
import com.example.soultosoul.MarfaQ.Entities.Blog;
import com.example.soultosoul.MarfaQ.Network.NetworkService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    private MutableLiveData<List<Blog>> allBlog = new MutableLiveData<>();
    private MutableLiveData<List<Article>> allArticle = new MutableLiveData<>();
    private NetworkService service;
    private MutableLiveData<Article> articleById = new MutableLiveData<>();
    private MutableLiveData<List<Article>> allArticleByCatProb = new MutableLiveData<>();
    private MutableLiveData<List<Article>> allArticleByCat = new MutableLiveData<>();

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

    public MutableLiveData<List<Article>> getAllArticle() {
        service.getJSONApi().getAllArticles().enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                if (response.isSuccessful()){
                    List<Article> articles = response.body();
                    allArticle.setValue(articles);
                }
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return allArticle;
    }

    public MutableLiveData<Article> getArticleById(long id){
        service.getJSONApi().getArticleWithID(id).enqueue(new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                if (response.isSuccessful()){
                    Article article = response.body();
                    articleById.setValue(article);
                }
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {
                t.printStackTrace();

            }
        });
        return articleById;
    }


    public MutableLiveData<List<Article>> getArticleByCatProb(long catId, long probId){
        if(probId!=10){
        service.getJSONApi().getArticlesByCatProb(catId, probId).enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                if(response.isSuccessful()){
                    List<Article> articles = response.body();
                    allArticleByCatProb.setValue(articles);
                }
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                t.printStackTrace();

            }
        });
        } else {
            allArticleByCatProb = getArticleByCat((int)catId);
        }
        return allArticleByCatProb;
    }

    public MutableLiveData<List<Article>> getArticleByCat(int catId){
        service.getJSONApi().getArticlesByCat(catId).enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                if(response.isSuccessful()){
                    List<Article> articles = response.body();
                    allArticleByCat.setValue(articles);
                }
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                t.printStackTrace();

            }
        });
        return allArticleByCat;
    }

    public MutableLiveData<List<Article>> getArticleKid(){
        service.getJSONApi().getArticlesByKid().enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                if(response.isSuccessful()){
                    List<Article> articles = response.body();
                    allArticleByCat.setValue(articles);
                }
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                t.printStackTrace();

            }
        });
        return allArticleByCat;
    }


    public MutableLiveData<List<Article>> getAllArticleWithImages() {
        service.getJSONApi().getAllArticles().enqueue(new Callback<List<Article>>() {

            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                if (response.isSuccessful()){

                    JSONObject obj = null;
                    try {
                        obj = new JSONObject(String.valueOf(response));
                        String imageUrl = obj.getJSONObject("image").getString("url");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    List<Article> articles = response.body();
                    allArticle.setValue(articles);


                }
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return allArticle;
    }



}
