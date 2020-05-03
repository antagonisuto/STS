package com.example.soultosoul.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//Sts_blog(id, title, content, user_id)
public class Blog {

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("content")
    @Expose
    private String content;

    @SerializedName("user_id")
    @Expose
    private long user_id;


    public Blog(String title,  String content, long user_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
    }

    public long getId() {
        return this.id;
    }

    public void setId( long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle( String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent( String content) {
        this.content = content;
    }

    public long getUser_id() {
        return this.user_id;
    }

    public void setUser_id( long user_id) {
        this.user_id = user_id;
    }


}
