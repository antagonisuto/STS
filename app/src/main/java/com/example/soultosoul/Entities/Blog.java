package com.example.soultosoul.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

//Sts_blog(id, title, content, user_id)
public class Blog implements Serializable {

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("shortContent")
    @Expose
    private String shortContent;

    @SerializedName("content")
    @Expose
    private String content;

    @SerializedName("status")
    @Expose
    private String status;

//    @SerializedName("user")
//    @Expose
//    private Users user;

    public Blog(String title,  String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        //this.user = user;
    }

//    public Blog(String title,  String content, Users user) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//        //this.user = user;
//    }

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

//    public Users getUser() {
//        return user;
//    }
//
//    public void setUser(Users user) {
//        this.user = user;
//    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }
}
