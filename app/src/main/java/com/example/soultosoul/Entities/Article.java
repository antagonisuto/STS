package com.example.soultosoul.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

//Sts_article(id, title, content, category_id, mood_id, problem_id, user_id)
public class Article implements Serializable {

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("content")
    @Expose
    private String content;

    @SerializedName("category_id")
    @Expose
    private long category_id;

    @SerializedName("mood_id")
    @Expose
    private long mood_id;

    @SerializedName("problem_id")
    @Expose
    private long problem_id;

    @SerializedName("user_id")
    @Expose
    private long user_id;

    public Article( String title,  String content,  long category_id,  long mood_id,  long problem_id,  long user_id) {
        this.title = title;
        this.content = content;
        this.category_id = category_id;
        this.mood_id = mood_id;
        this.problem_id = problem_id;
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

    public long getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id( long category_id) {
        this.category_id = category_id;
    }

    public long getMood_id() {
        return this.mood_id;
    }

    public void setMood_id( long mood_id) {
        this.mood_id = mood_id;
    }

    public long getProblem_id() {
        return this.problem_id;
    }

    public void setProblem_id( long problem_id) {
        this.problem_id = problem_id;
    }

    public long getUser_id() {
        return this.user_id;
    }

    public void setUser_id( long user_id) {
        this.user_id = user_id;
    }
}
