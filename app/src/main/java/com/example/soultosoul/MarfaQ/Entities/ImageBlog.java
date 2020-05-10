package com.example.soultosoul.MarfaQ.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Sts_image_blog(id, url, blog_id)
public class ImageBlog {

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("blog_id")
    @Expose
    private long blog_id;

    public ImageBlog(String url, long blog_id) {
        this.id = id;
        this.url = url;
        this.blog_id = blog_id;
    }

    public long getId() {
        return this.id;
    }

    public void setId( long id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl( String url) {
        this.url = url;
    }

    public long getBlog_id() {
        return this.blog_id;
    }

    public void setBlog_id( long blog_id) {
        this.blog_id = blog_id;
    }
}
