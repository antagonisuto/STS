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
//    @GET("/posts/{id}")
//    public Call<Post> getPostWithID(@Path("id") int id);
//
//    @GET("/posts")
//    public Call<List<Post>> getAllPosts();
//
//    @GET("/posts")
//    public Call<List<Post>> getPostOfUser(@Query("userId") int id);
//
//    @POST("/posts")
//    public Call<Post> postData(@Body Post data);

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




}
