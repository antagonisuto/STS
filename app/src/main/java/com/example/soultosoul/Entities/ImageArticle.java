package com.example.soultosoul.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageArticle {

    //Sts_image_article(id, url, article_id)

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("article_id")
    @Expose
    private long article_id;

    public ImageArticle(String url, long article_id) {
        this.url = url;
        this.article_id = article_id;
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

    public long getArticle_id() {
        return this.article_id;
    }

    public void setArticle_id( long article_id) {
        this.article_id = article_id;
    }
}
