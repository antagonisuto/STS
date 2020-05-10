package com.example.soultosoul.MarfaQ.Network;

import com.example.soultosoul.MarfaQ.Entities.Article;
import com.example.soultosoul.MarfaQ.Entities.Blog;
import com.example.soultosoul.MarfaQ.Entities.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JSONPlaceHolderApi {

    /**
     * UNAUTHORIZED
     **/
    @POST("api/v1/unauthorized/user")
    Call<Users> getAllUser(@Body Users data);

    @GET("api/v1/unauthorized/articles")
    Call<List<Article>> getAllArticles();

    @GET("api/v1/unauthorized/article/{id}")
    Call<Article> getArticleWithID(@Path("id") int id);

    @GET("api/v1/unauthorized/blogs")
    Call<List<Blog>> getAllBlogs();

    @GET("api/v1/unauthorized/blog/{id}")
    Call<Blog> getBlogWithID(@Path("id") int id);

    //kids - 1, teenagers - 2, young people - 3, adults - 4
    @GET("api/v1/unauthorized/articles/category/{categoryId}/mood/{moodId}/problem/{problemId}")
    Call<List<Article>> getArticlesByCatMoodProb(@Path("categoryId") int categoryId, @Path("moodId") int moodId, @Path("problemId") int problemId);

}
