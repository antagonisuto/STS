package com.example.soultosoul.Network;

import com.example.soultosoul.Entities.Article;
import com.example.soultosoul.Entities.Blog;
import com.example.soultosoul.Entities.Post;
import com.example.soultosoul.Entities.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {

    /**UNAUTHORIZED**/
    @POST("api/v1/unauthorized/user")
    public Call<Users> getAllUser (@Body Users data);

    @GET("api/v1/unauthorized/articles")
    public Call<List<Article>> getAllArticles();

    @GET("api/v1/unauthorized/article/{id}")
    public Call<Article> getArticleWithID(@Path("id") int id);

    @GET("api/v1/unauthorized/blogs")
    public Call<List<Blog>> getAllBlogs();

    @GET("api/v1/unauthorized/blog/{id}")
    public Call<Blog> getBlogWithID(@Path("id") int id);

    //kids - 1, teenagers - 2, young people - 3, adults - 4
    @GET("api/v1/unauthorized/articles/category/{categoryId}/mood/{moodId}/problem/{problemId}")
    public Call<List<Article>> getArticlesByCatMoodProb(@Path("categoryId") int categoryId, @Path("moodId") int moodId, @Path("problemId") int problemId);

    @GET("api/v1/unauthorized/articles/category/{categoryId}/problem/{problemId}")
    public Call<List<Article>> getArticlesByCatProb(@Path("categoryId") int categoryId, @Path("problemId") int problemId);

    @GET("api/v1/unauthorized/articles/category/{categoryId}")
    public Call<List<Article>> getArticlesByCat(@Path("categoryId") int categoryId);
}
